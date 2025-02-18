package ru.rim.project.di

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.rim.project.data.NetworkCharactersDataSource
import ru.rim.project.data.getNetworkClient
import ru.rim.project.data.requests.CharacterPagingSource
import ru.rim.project.domain.repository.CharacterRepository
import ru.rim.project.navigation.RootComponent
import ru.rim.project.presentation.CharactersViewModel


actual fun viewModelModule(): Module = module {
    singleOf(::getNetworkClient)
    single { NetworkCharactersDataSource(get()) }
    single { CharacterPagingSource(get()) }
    single { CharacterRepository(get()) }
    single { RootComponent(get()) }
    viewModel { CharactersViewModel(get()) }
}