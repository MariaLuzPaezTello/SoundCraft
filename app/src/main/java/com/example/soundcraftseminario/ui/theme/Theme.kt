package com.example.soundcraftseminario.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val SoundcraftDarkColorScheme = darkColorScheme(
    primary = NeonPurple,
    onPrimary = TextWhite,
    secondary = NeonPink,
    onSecondary = TextWhite,
    tertiary = NeonCyan,
    onTertiary = TextWhite,
    background = DarkBackground,
    onBackground = TextWhite,
    surface = DarkSurface,
    onSurface = TextWhite,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondary,
    outline = OutlinePurple
)

@Composable
fun SoundcraftTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SoundcraftDarkColorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun SoundcraftseminarioTheme(
    content: @Composable () -> Unit
) {
    SoundcraftTheme(content = content)
}
