package com.example.soundcraftseminario.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.soundcraftseminario.ui.screens.ImportSoundScreen
import com.example.soundcraftseminario.ui.screens.LibraryScreen
import com.example.soundcraftseminario.ui.screens.LoginScreen
import com.example.soundcraftseminario.ui.screens.RegisterScreen

enum class SoundcraftScreen {
    Login,
    Register,
    Library,
    ImportSound
}

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    var currentScreen by remember { mutableStateOf(SoundcraftScreen.Login) }

    when (currentScreen) {
        SoundcraftScreen.Login -> {
            LoginScreen(
                onLoginClick = { currentScreen = SoundcraftScreen.Library },
                onRegisterClick = { currentScreen = SoundcraftScreen.Register },
                modifier = modifier
            )
        }

        SoundcraftScreen.Register -> {
            RegisterScreen(
                onRegisterSubmit = { currentScreen = SoundcraftScreen.Library },
                onBackToLoginClick = { currentScreen = SoundcraftScreen.Login },
                modifier = modifier
            )
        }

        SoundcraftScreen.Library -> {
            LibraryScreen(
                onNavigateToImport = { currentScreen = SoundcraftScreen.ImportSound },
                modifier = modifier
            )
        }

        SoundcraftScreen.ImportSound -> {
            ImportSoundScreen(
                onBackClick = { currentScreen = SoundcraftScreen.Library },
                onImportSuccess = { currentScreen = SoundcraftScreen.Library },
                modifier = modifier
            )
        }
    }
}
