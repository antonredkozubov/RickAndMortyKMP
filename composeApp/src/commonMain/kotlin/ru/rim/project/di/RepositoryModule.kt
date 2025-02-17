package ru.rim.project.di

import org.koin.dsl.module
import ru.rim.project.data.NetworkCharactersDataSource

//val repositoryModule = module {
//    singleOf(::CharactersRepositoryImpl) {
//        bind<CharactersRepository>()
//    }
//}
val repositoryModule = module {
    single { NetworkCharactersDataSource(get()) }
}
