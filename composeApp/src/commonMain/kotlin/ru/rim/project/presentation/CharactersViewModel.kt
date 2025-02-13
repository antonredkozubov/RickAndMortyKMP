package ru.rim.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.rim.project.domain.BaseResult
import ru.rim.project.domain.repository.CharactersRepository

class CharactersViewModel(private val repository: CharactersRepository): ViewModel() {

    private val _stateUI = MutableStateFlow(CharactersStateUI())
    val stateUI: StateFlow<CharactersStateUI> get() = _stateUI.asStateFlow()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        _stateUI.update { _stateUI.value.copy(error = null, loading = true) }
        viewModelScope.launch(Dispatchers.Main) {
            when(val result = repository.getCharacters()) {
                is BaseResult.Error -> _stateUI.update {
                    _stateUI.value.copy(
                        error = result.exception,
                        loading = false
                    )
                }
                is BaseResult.Success -> _stateUI.update {
                    _stateUI.value.copy(
                        characters = result.data,
                        error = null,
                        loading = false
                    )
                }
            }
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}