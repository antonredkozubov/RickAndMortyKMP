package ru.rim.project.data.model

data class CharactersResponse(
    val info: Info,
    val results: List<CharacterDTO>
)