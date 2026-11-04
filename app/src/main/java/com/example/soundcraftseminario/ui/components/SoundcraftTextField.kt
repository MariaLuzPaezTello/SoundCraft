package com.example.soundcraftseminario.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.soundcraftseminario.ui.theme.DarkSurface
import com.example.soundcraftseminario.ui.theme.DarkSurfaceVariant
import com.example.soundcraftseminario.ui.theme.NeonPink
import com.example.soundcraftseminario.ui.theme.NeonPurple
import com.example.soundcraftseminario.ui.theme.TextSecondary
import com.example.soundcraftseminario.ui.theme.TextWhite

@Composable
fun SoundcraftTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    isPassword: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        singleLine = true,
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        leadingIcon = leadingIcon,
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions.Default,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = DarkSurfaceVariant,
            unfocusedContainerColor = DarkSurface,
            focusedBorderColor = NeonPink,
            unfocusedBorderColor = NeonPurple.copy(alpha = 0.5f),
            focusedLabelColor = NeonPink,
            unfocusedLabelColor = TextSecondary,
            focusedTextColor = TextWhite,
            unfocusedTextColor = TextWhite,
            cursorColor = NeonPink
        )
    )
}
