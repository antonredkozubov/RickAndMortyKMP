package ru.rim.project.feature.details

import com.arkivanov.decompose.ComponentContext
import ru.rim.project.domain.model.Character

class DetailsComponent(
    val model: Character,
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {
    fun goBack() {
        onGoBack()
    }
}