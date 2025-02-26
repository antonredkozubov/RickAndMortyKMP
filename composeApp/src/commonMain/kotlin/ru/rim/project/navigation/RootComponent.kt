package ru.rim.project.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable
import ru.rim.project.domain.model.Character
import ru.rim.project.feature.details.DetailsComponent


class RootComponent(
    componentContext: ComponentContext
): ComponentContext by componentContext {
    private val navigation = StackNavigation<Configuration>()
    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.Home,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when(config) {
            Configuration.Home -> Child.Home(
                HomeComponent(
                    componentContext = context,
                    onNavigateToDetails = { model ->
                        navigation.pushNew(Configuration.Details(model))
                    }
                )
            )
            is Configuration.Details -> Child.Details(
                DetailsComponent(
                    model = config.model,
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