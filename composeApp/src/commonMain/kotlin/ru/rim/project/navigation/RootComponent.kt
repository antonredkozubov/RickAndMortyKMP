package ru.rim.project.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable
import ru.rim.project.domain.model.Character


class RootComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.ScreenA,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when(config) {
            Configuration.Home -> Child.Home(
                HomeComponent(
                    componentContext = context,
                    onNavigateToScreenB = { model ->
                        navigation.pushNew(Configuration.Details(model))
                    }
                )
            )
            is Configuration.Details -> Child.Details(
                DetailsComponent(
                    text = config.text,
                    componentContext = context,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )
        }
    }

    sealed class Child {
        data class Home(val component: HomeComponent): Child()
        data class Details(val component: DetailsComponent): Child()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object Home: Configuration()

        @Serializable
        data class Details(val model: Character): Configuration()
    }
}