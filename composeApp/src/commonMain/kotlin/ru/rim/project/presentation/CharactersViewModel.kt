package ru.rim.project.presentation

import androidx.lifecycle.ViewModel
import ru.rim.project.domain.repository.CharactersRepository

class CharactersViewModel(private val repository: CharactersRepository): ViewModel() {

    init {
        getCharacters()
    }

    private fun getCharacters() {

    }
}