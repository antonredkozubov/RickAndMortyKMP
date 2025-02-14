package ru.rim.project.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import ru.rim.project.presentation.CharactersViewModel


actual fun viewModelModule(): Module = module {
    factoryOf(::CharactersViewModel)
}