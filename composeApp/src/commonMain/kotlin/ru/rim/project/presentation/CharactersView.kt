package ru.rim.project.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import ru.rim.project.designsystem.component.RMCard

@Composable
fun CharactersView() {
    val viewModel: CharactersViewModel = koinInject()
    val uiState by viewModel.stateUI.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        if(uiState.loading) {
            CircularProgressIndicator(
                modifier = Modifier.width(70.dp).align(Alignment.Center),
                color = MaterialTheme.colors.onPrimary
            )
        }

        AnimatedVisibility(!uiState.loading) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                items(uiState.characters) {
                    RMCard(it)
                }
            }
        }
    }
}