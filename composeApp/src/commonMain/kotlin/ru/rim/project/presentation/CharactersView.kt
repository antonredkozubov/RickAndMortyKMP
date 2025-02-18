package ru.rim.project.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.koin.compose.koinInject
import ru.rim.project.designsystem.component.RMCard
import ru.rim.project.domain.model.Character
import ru.rim.project.navigation.HomeComponent
import ru.rim.project.navigation.HomeEvent

@Composable
fun CharactersView(
    viewModel: CharactersViewModel = koinInject(),
    component: HomeComponent
) {
    val characters: LazyPagingItems<Character> = viewModel.charactersPagingFlow.collectAsLazyPagingItems()
    val model by component.model.subscribeAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        when {
            characters.loadState.refresh is LoadState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(70.dp)
                        .align(Alignment.Center),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            characters.itemCount > 0 -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp),
                    verticalArrangement = Arrangement.spacedBy(25.dp)
                ) {
                    items(characters.itemCount) { index ->
                        val character = characters[index]
                        character?.let { RMCard(it,
                            onClick = {
                            component.onEvent(HomeEvent.GoToDetails(it))
                        }) }
                    }

                    when (characters.loadState.append) {
                        is LoadState.Loading -> {
                            item {
                                CircularProgressIndicator(
                                    modifier = Modifier.fillMaxWidth(),
                                    color = MaterialTheme.colors.onPrimary
                                )
                            }
                        }
                        is LoadState.Error -> {
                            item {
                                Text(
                                    text = "Ошибка загрузки данных",
                                    modifier = Modifier.fillMaxWidth(),
                                    color = Color.Red
                                )
                            }
                        }
                        else -> {}
                    }
                }
            }
            characters.loadState.refresh is LoadState.Error -> {
                Text(
                    text = "Ошибка загрузки данных",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Red
                )
            }
        }
    }
}