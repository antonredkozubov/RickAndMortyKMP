package ru.rim.project.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.rim.project.data.NetworkCharactersDataSource
import ru.rim.project.domain.repository.CharacterRepository
import ru.rim.project.presentation.CharactersViewModel


actual fun viewModelModule(): Module = module {
    single { HttpClient(OkHttp) }
    single { NetworkCharactersDataSource(get()) }
    single { CharacterRepository(get()) }
    viewModel { CharactersViewModel(get()) }
}