package ru.rim.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import ru.rim.project.designsystem.theme.RickAndMortyAppTheme
import ru.rim.project.presentation.CharactersView

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    KoinContext {
        RickAndMortyAppTheme {
            CharactersView()
        }
    }
}