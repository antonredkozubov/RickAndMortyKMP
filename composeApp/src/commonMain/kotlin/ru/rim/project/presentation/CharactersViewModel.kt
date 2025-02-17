package ru.rim.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import ru.rim.project.domain.model.Character
import ru.rim.project.domain.repository.CharacterRepository


class CharactersViewModel(private val repository: CharacterRepository) : ViewModel() {

//    init {
//        viewModelScope.launch {
//            try {
//                repository.getCharactersPager().collect { pagingData ->
//                    _stateUI.value = pagingData
//                }
//            } catch (e: Exception) {
//                Log.e("CharactersViewModel", "Ошибка при загрузке данных", e)
//            }
//        }
//    }

    val charactersPagingFlow: Flow<PagingData<Character>> =
        repository.getCharactersPager()
            .cachedIn(viewModelScope)
}

//class CharactersViewModel(private val repository: CharactersRepository): ViewModel() {
//
//    private val _stateUI = MutableStateFlow(CharactersStateUI())
//    val stateUI: StateFlow<CharactersStateUI> get() = _stateUI.asStateFlow()
//
//    init {
//        getCharacters()
//    }
//
//    private fun getCharacters() {
//        _stateUI.update { _stateUI.value.copy(error = null, loading = true) }
//        viewModelScope.launch(Dispatchers.Main) {
//            when(val result = repository.getCharacters()) {
//                is BaseResult.Error -> _stateUI.update {
//                    _stateUI.value.copy(
//                        error = result.exception,
//                        loading = false
//                    )
//                }
//                is BaseResult.Success -> _stateUI.update {
//                    _stateUI.value.copy(
//                        characters = result.data,
//                        error = null,
//                        loading = false
//                    )
//                }
//            }
//        }
//    }
//
//    override fun onCleared() {
//        viewModelScope.cancel()
//        super.onCleared()
//    }
//}