package ru.rim.project

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.core.context.startKoin
import ru.rim.project.di.dataSourceModule
import ru.rim.project.di.networkModule
import ru.rim.project.di.repositoryModule
import ru.rim.project.di.viewModelModule

fun MainViewController() = ComposeUIViewController { App() }

fun initKoin() {
    startKoin {
        modules(networkModule, dataSourceModule, repositoryModule, viewModelModule())
    }
}