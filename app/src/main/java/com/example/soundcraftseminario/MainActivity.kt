package com.example.soundcraftseminario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.soundcraftseminario.ui.navigation.AppNavigation
import com.example.soundcraftseminario.ui.theme.SoundcraftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SoundcraftTheme {
                AppNavigation()
            }
        }
    }
}
