package ru.rim.project.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.rim.project.data.NetworkCharactersDataSource

val dataSourceModule = module {
    singleOf(:: NetworkCharactersDataSource )
}