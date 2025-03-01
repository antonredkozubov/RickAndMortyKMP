package ru.rim.project.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


val appDarkColors = darkColors(
    background = AppColors.Background,
    onPrimary = AppColors.Primary
)
val appLightColors = lightColors(
    background = AppColors.Background,
    onPrimary = AppColors.Primary
)
@Composable
fun RickAndMortyAppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isDarkTheme) appDarkColors else appLightColors,
        content = { content() }
    )
}