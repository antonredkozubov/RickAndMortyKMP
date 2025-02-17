package ru.rim.project

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.rim.project.di.dataSourceModule
import ru.rim.project.di.networkModule
import ru.rim.project.di.repositoryModule
import ru.rim.project.di.viewModelModule

class RickAndMortyApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RickAndMortyApp)
            androidLogger()
            modules(networkModule, dataSourceModule, repositoryModule, viewModelModule())
        }
    }
}