package ru.rim.project.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    val info: Info,
    val results: List<CharacterDTO>
)