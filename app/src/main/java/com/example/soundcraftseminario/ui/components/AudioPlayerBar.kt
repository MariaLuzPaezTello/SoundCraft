package com.example.soundcraftseminario.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.soundcraftseminario.data.mock.SoundPadItem
import com.example.soundcraftseminario.ui.theme.DarkSurfaceVariant
import com.example.soundcraftseminario.ui.theme.NeonCyan
import com.example.soundcraftseminario.ui.theme.NeonPink
import com.example.soundcraftseminario.ui.theme.NeonPurple
import com.example.soundcraftseminario.ui.theme.OutlinePurple
import com.example.soundcraftseminario.ui.theme.TextSecondary
import com.example.soundcraftseminario.ui.theme.TextWhite

// Vector Icon Play (0 dependencias)
val PlayVectorIcon: ImageVector = ImageVector.Builder(
    name = "Play",
    defaultWidth = 24.dp,
    defaultHeight = 24.dp,
    viewportWidth = 24f,
    viewportHeight = 24f
).path(fill = SolidColor(Color.White)) {
    moveTo(8f, 5f)
    lineTo(19f, 12f)
    lineTo(8f, 19f)
    close()
}.build()

// Vector Icon Pause (0 dependencias)
val PauseVectorIcon: ImageVector = ImageVector.Builder(
    name = "Pause",
    defaultWidth = 24.dp,
    defaultHeight = 24.dp,
    viewportWidth = 24f,
    viewportHeight = 24f
).path(fill = SolidColor(Color.White)) {
    moveTo(6f, 19f)
    horizontalLineTo(10f)
    verticalLineTo(5f)
    horizontalLineTo(6f)
    close()
    moveTo(14f, 5f)
    verticalLineTo(19f)
    horizontalLineTo(18f)
    verticalLineTo(5f)
    close()
}.build()

@Composable
fun AudioPlayerBar(
    activePad: SoundPadItem?,
    isPlaying: Boolean,
    onPlayPauseToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = DarkSurfaceVariant,
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        shadowElevation = 12.dp,
        tonalElevation = 6.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            // Barra de progreso de reproducción simulada
            LinearProgressIndicator(
                progress = { if (isPlaying && activePad != null) 0.65f else 0.0f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp),
                color = NeonCyan,
                trackColor = OutlinePurple
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Indicador circular del estado
                Surface(
                    color = activePad?.color ?: NeonPurple.copy(alpha = 0.3f),
                    shape = CircleShape,
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        imageVector = if (isPlaying) PauseVectorIcon else PlayVectorIcon,
                        contentDescription = "Estado de sonido",
                        tint = TextWhite,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Detalles del sonido activo
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = activePad?.name ?: "Ningún pad seleccionado",
                        color = TextWhite,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text(
                        text = activePad?.let { "${it.category} • Formato ${it.format}" }
                            ?: "Toca un pad de la biblioteca para reproducir",
                        color = TextSecondary,
                        fontSize = 11.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Botón Play / Pause
                IconButton(
                    onClick = onPlayPauseToggle,
                    enabled = activePad != null,
                    modifier = Modifier.size(48.dp)
                ) {
                    Surface(
                        color = if (isPlaying) NeonPink else NeonPurple,
                        shape = CircleShape,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            imageVector = if (isPlaying) PauseVectorIcon else PlayVectorIcon,
                            contentDescription = if (isPlaying) "Pausar" else "Reproducir",
                            tint = TextWhite,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}
