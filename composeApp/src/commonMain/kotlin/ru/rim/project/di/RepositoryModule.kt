package ru.rim.project.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.rim.project.data.repository.CharactersRepositoryImpl
import ru.rim.project.domain.repository.CharactersRepository

val repositoryModule = module {
    singleOf(::CharactersRepositoryImpl) {
        bind<CharactersRepository>()
    }
}