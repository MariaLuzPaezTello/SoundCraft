package com.example.soundcraftseminario.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soundcraftseminario.data.mock.MockSoundData
import com.example.soundcraftseminario.data.mock.SoundPadItem
import com.example.soundcraftseminario.ui.components.AudioPlayerBar
import com.example.soundcraftseminario.ui.components.CategoryChip
import com.example.soundcraftseminario.ui.components.SoundPad
import com.example.soundcraftseminario.ui.theme.DarkBackground
import com.example.soundcraftseminario.ui.theme.DarkSurface
import com.example.soundcraftseminario.ui.theme.NeonPink
import com.example.soundcraftseminario.ui.theme.NeonPurple
import com.example.soundcraftseminario.ui.theme.TextSecondary
import com.example.soundcraftseminario.ui.theme.TextWhite

@Composable
fun LibraryScreen(
    onNavigateToImport: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf("Todos") }
    var selectedPad by remember { mutableStateOf<SoundPadItem?>(MockSoundData.soundPads.first()) }
    var isPlaying by remember { mutableStateOf(false) }

    // Filtrado de pads según categoría seleccionada
    val filteredPads = remember(selectedCategory) {
        if (selectedCategory == "Todos") {
            MockSoundData.soundPads
        } else {
            MockSoundData.soundPads.filter { it.category == selectedCategory }
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = DarkBackground,
        bottomBar = {
            AudioPlayerBar(
                activePad = selectedPad,
                isPlaying = isPlaying,
                onPlayPauseToggle = { isPlaying = !isPlaying }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // Cabecera superior
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "SOUNDCRAFT",
                        color = TextWhite,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "16-PAD SAMPLER GRID",
                        color = NeonPink,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = onNavigateToImport,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NeonPurple,
                        contentColor = TextWhite
                    ),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "+ IMPORTAR",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Selector de Categorías (LazyRow)
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(MockSoundData.categories) { category ->
                    CategoryChip(
                        category = category,
                        isSelected = (selectedCategory == category),
                        onClick = { selectedCategory = category }
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Cuadrícula 4x4 de 16 Pads (LazyVerticalGrid con 4 columnas)
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                items(filteredPads, key = { it.id }) { pad ->
                    SoundPad(
                        pad = pad,
                        isSelected = (selectedPad?.id == pad.id),
                        onClick = {
                            selectedPad = pad
                            isPlaying = true
                        }
                    )
                }
            }
        }
    }
}
