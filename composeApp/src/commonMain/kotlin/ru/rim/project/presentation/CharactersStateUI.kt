package ru.rim.project.presentation

import ru.rim.project.domain.model.Character

data class CharactersStateUI(
    val characters: List<Character> = listOf(),
    val error: Exception? = null,
    val loading: Boolean = false
)
