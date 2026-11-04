package com.example.soundcraftseminario.data.mock

import androidx.compose.ui.graphics.Color
import com.example.soundcraftseminario.ui.theme.PadBassColor
import com.example.soundcraftseminario.ui.theme.PadDrumsColor
import com.example.soundcraftseminario.ui.theme.PadFXColor
import com.example.soundcraftseminario.ui.theme.PadSynthsColor

data class SoundPadItem(
    val id: Int,
    val name: String,
    val category: String,
    val format: String,
    val color: Color
)

object MockSoundData {
    val categories = listOf("Todos", "Drums", "Bass", "Synths", "FX")

    val soundPads = listOf(
        // Drums (1 - 4)
        SoundPadItem(1, "Kick 808", "Drums", ".wav", PadDrumsColor),
        SoundPadItem(2, "Snare Trap", "Drums", ".wav", PadDrumsColor),
        SoundPadItem(3, "Hi-Hat Open", "Drums", ".wav", PadDrumsColor),
        SoundPadItem(4, "Clap Neón", "Drums", ".mp3", PadDrumsColor),
        // Bass (5 - 8)
        SoundPadItem(5, "Sub Bass", "Bass", ".wav", PadBassColor),
        SoundPadItem(6, "Reese Synth", "Bass", ".wav", PadBassColor),
        SoundPadItem(7, "Slap Bass", "Bass", ".mp3", PadBassColor),
        SoundPadItem(8, "Acid Line", "Bass", ".wav", PadBassColor),
        // Synths (9 - 12)
        SoundPadItem(9, "Synth Lead", "Synths", ".wav", PadSynthsColor),
        SoundPadItem(10, "Synth Chord", "Synths", ".mp3", PadSynthsColor),
        SoundPadItem(11, "Arp 80s", "Synths", ".wav", PadSynthsColor),
        SoundPadItem(12, "Ambient Pad", "Synths", ".wav", PadSynthsColor),
        // FX (13 - 16)
        SoundPadItem(13, "Laser FX", "FX", ".mp3", PadFXColor),
        SoundPadItem(14, "Riser Sweep", "FX", ".wav", PadFXColor),
        SoundPadItem(15, "Vinyl Scratch", "FX", ".mp3", PadFXColor),
        SoundPadItem(16, "Vocal Drop", "FX", ".wav", PadFXColor)
    )
}
