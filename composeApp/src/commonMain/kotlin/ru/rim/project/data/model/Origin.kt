package ru.rim.project.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Origin(
    val name: String,
    val url: String
)