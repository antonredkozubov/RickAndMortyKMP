package ru.rim.project.domain.repository

import ru.rim.project.domain.BaseResult
import ru.rim.project.domain.model.Character

interface CharactersRepository {
    suspend fun getCharacters(): BaseResult<List<Character>>
}