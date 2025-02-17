package ru.rim.project.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.rim.project.data.NetworkCharactersDataSource
import ru.rim.project.data.requests.CharacterPagingSource
import ru.rim.project.domain.model.Character

class CharacterRepository(
    private val api: NetworkCharactersDataSource
) {
    fun getCharactersPager(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 2,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CharacterPagingSource(api) }
        ).flow
    }
}