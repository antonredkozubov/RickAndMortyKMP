package ru.rim.project.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import org.koin.core.component.KoinComponent
import ru.rim.project.domain.model.Character


class HomeComponent(
    componentContext: ComponentContext,
    private val onNavigateToDetails: (Character) -> Unit
) : ComponentContext by componentContext, KoinComponent {

//    val viewModel: CharactersViewModel by koinInject()

    private val _model = MutableValue(Character("", "", "", "", "", ""))
    val model: Value<Character> = _model

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.GoToDetails -> {
                _model.value = event.model
                onNavigateToDetails(_model.value)
            }
        }
    }
}