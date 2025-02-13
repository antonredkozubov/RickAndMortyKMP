package ru.rim.project.data.repository

import ru.rim.project.data.NetworkCharactersDataSource
import ru.rim.project.data.mapper.toDomain
import ru.rim.project.domain.BaseResult
import ru.rim.project.domain.model.Character
import ru.rim.project.domain.repository.CharactersRepository

class CharactersRepositoryImpl(private val dataSource: NetworkCharactersDataSource): CharactersRepository {
    override suspend fun getCharacters(): BaseResult<List<Character>> {
        return try {
            val characters = dataSource.getCharacters().toDomain()
            BaseResult.Success(characters)
        } catch (e: Exception) {
            BaseResult.Error(e)
        }
    }
}