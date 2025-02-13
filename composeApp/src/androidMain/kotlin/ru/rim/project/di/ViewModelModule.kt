package ru.rim.project.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.rim.project.presentation.CharactersViewModel


actual fun viewModelModule(): Module = module {
    viewModelOf(::CharactersViewModel)
}