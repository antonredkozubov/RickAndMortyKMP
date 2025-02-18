package ru.rim.project.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val name: String,
    val originName: String,
    val spicies: String,
    val gender: String,
    val status: String,
    val image: String
)