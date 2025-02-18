package ru.rim.project

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import ru.rim.project.designsystem.theme.RickAndMortyAppTheme
import ru.rim.project.feature.details.DetailsScreen
import ru.rim.project.navigation.RootComponent
import ru.rim.project.presentation.CharactersView

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(root: RootComponent) {
    KoinContext {
        RickAndMortyAppTheme {
            val childStack by root.childStack.subscribeAsState()
            Children(
                stack = childStack,
                animation = stackAnimation(slide())
            ) { child ->
                when(val instance = child.instance) {
                    is RootComponent.Child.Home -> CharactersView(component = instance.component)
                    is RootComponent.Child.Details -> DetailsScreen(instance.component.model, instance.component)
                }
            }
        }
    }
}