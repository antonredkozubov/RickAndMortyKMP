package ru.rim.project.data.mapper

import ru.rim.project.data.model.CharacterDTO
import ru.rim.project.data.model.CharactersResponse
import ru.rim.project.domain.model.Character

fun CharactersResponse.toDomain(): List<Character> = results.map { it.toDomain() }

fun CharacterDTO.toDomain() =
    Character (
        name = name,
        originName = origin.name,
        spicies = species,
        gender = gender,
        status = status,
        image = image
    )