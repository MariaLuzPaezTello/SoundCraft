package com.example.soundcraftseminario.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.soundcraftseminario.ui.components.SoundcraftTextField
import com.example.soundcraftseminario.ui.theme.DarkBackground
import com.example.soundcraftseminario.ui.theme.DarkSurface
import com.example.soundcraftseminario.ui.theme.NeonCyan
import com.example.soundcraftseminario.ui.theme.NeonGreen
import com.example.soundcraftseminario.ui.theme.NeonPink
import com.example.soundcraftseminario.ui.theme.NeonPurple
import com.example.soundcraftseminario.ui.theme.TextSecondary
import com.example.soundcraftseminario.ui.theme.TextWhite

@Composable
fun ImportSoundScreen(
    onBackClick: () -> Unit,
    onImportSuccess: () -> Unit,
    modifier: Modifier = Modifier
) {
    var padName by remember { mutableStateOf("Cyber Drop") }
    var selectedCategory by remember { mutableStateOf("Synths") }
    var selectedFormat by remember { mutableStateOf(".wav") }
    var selectedFileSimulated by remember { mutableStateOf("muestra_cyber_drop_808.wav (1.2 MB)") }
    var showSuccessMessage by remember { mutableStateOf(false) }

    val categories = listOf("Drums", "Bass", "Synths", "FX")
    val formats = listOf(".wav", ".mp3")

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBackground)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Botón de regreso
            TextButton(
                onClick = onBackClick,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(
                    text = "← VOLVER A LA BIBLIOTECA",
                    color = NeonPink,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = DarkSurface),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    Text(
                        text = "IMPORTAR Y CATALOGAR AUDIO",
                        color = TextWhite,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )

                    Text(
                        text = "Asigna metadatos y formato para ubicarlo en la cuadrícula",
                        color = TextSecondary,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
                    )

                    // Sección 1: Selección visual de archivo
                    Text(
                        text = "1. Archivo de Audio (Simulado)",
                        color = NeonPurple,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    OutlinedButton(
                        onClick = {
                            selectedFileSimulated = "sample_importado_${(10..99).random()}.mp3 (0.9 MB)"
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "📁 EXAMINAR ARCHIVO (.MP3 / .WAV)",
                            color = NeonCyan,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }

                    Surface(
                        color = DarkBackground,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 16.dp)
                    ) {
                        Text(
                            text = "Archivo seleccionado: $selectedFileSimulated",
                            color = TextWhite,
                            fontSize = 11.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    // Sección 2: Asignación de Nombre
                    Text(
                        text = "2. Nombre del Pad",
                        color = NeonPurple,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    SoundcraftTextField(
                        value = padName,
                        onValueChange = { padName = it },
                        label = "Nombre del Pad",
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sección 3: Categoría
                    Text(
                        text = "3. Seleccionar Categoría",
                        color = NeonPurple,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        categories.forEach { cat ->
                            FilterChip(
                                selected = (selectedCategory == cat),
                                onClick = { selectedCategory = cat },
                                label = { Text(cat, fontSize = 12.sp) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = NeonPink,
                                    selectedLabelColor = TextWhite
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sección 4: Formato Visual
                    Text(
                        text = "4. Formato de Audio",
                        color = NeonPurple,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        formats.forEach { fmt ->
                            FilterChip(
                                selected = (selectedFormat == fmt),
                                onClick = { selectedFormat = fmt },
                                label = { Text(fmt.uppercase(), fontSize = 12.sp, fontWeight = FontWeight.Bold) },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = NeonCyan,
                                    selectedLabelColor = DarkBackground
                                )
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Botón Guardar Pad
                    Button(
                        onClick = {
                            showSuccessMessage = true
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = NeonPurple,
                            contentColor = TextWhite
                        )
                    ) {
                        Text(
                            text = "GUARDAR Y CATALOGAR PAD",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Mensaje visual de confirmación simulada
                    if (showSuccessMessage) {
                        Surface(
                            color = NeonGreen.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 16.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "✔ ¡Pad '$padName' ($selectedFormat) catalogado con éxito!",
                                    color = NeonGreen,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                TextButton(onClick = onImportSuccess) {
                                    Text(
                                        text = "VOLVER A LA BIBLIOTECA",
                                        color = TextWhite,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true, showSystemUi = true)
@Composable
fun ImportSoundScreenPreview() {
    com.example.soundcraftseminario.ui.theme.SoundcraftTheme {
        ImportSoundScreen(
            onBackClick = {},
            onImportSuccess = {}
        )
    }
}

