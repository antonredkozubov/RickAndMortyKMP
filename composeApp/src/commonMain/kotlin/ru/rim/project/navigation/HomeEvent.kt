package ru.rim.project.navigation

import ru.rim.project.domain.model.Character

sealed interface HomeEvent {
    data class GoToDetails(val model: Character): HomeEvent
}