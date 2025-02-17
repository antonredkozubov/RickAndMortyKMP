package ru.rim.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import ru.rim.project.domain.model.Character
import ru.rim.project.domain.repository.CharacterRepository

class CharactersViewModel(private val repository: CharacterRepository) : ViewModel() {

    val charactersPagingFlow: Flow<PagingData<Character>> =
        repository.getCharactersPager()
            .cachedIn(viewModelScope)
}