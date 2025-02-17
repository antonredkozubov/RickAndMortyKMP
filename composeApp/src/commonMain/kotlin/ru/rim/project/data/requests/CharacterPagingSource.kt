package ru.rim.project.data.requests

import app.cash.paging.PagingSource
import app.cash.paging.PagingState
import ru.rim.project.data.NetworkCharactersDataSource
import ru.rim.project.data.mapper.toDomain
import ru.rim.project.domain.model.Character

class CharacterPagingSource(
    private val api: NetworkCharactersDataSource
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val response = api.getCharacters(page)

            LoadResult.Page(
                data = response.results.map { it.toDomain() },
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.info.next != null) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }
}