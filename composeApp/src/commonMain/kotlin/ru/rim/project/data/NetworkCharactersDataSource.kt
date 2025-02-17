package ru.rim.project.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.rim.project.data.model.CharactersResponse

class NetworkCharactersDataSource(private val client: HttpClient) {
    suspend fun getCharacters(page: Int): CharactersResponse {
        return client.get("https://rickandmortyapi.com/api/character") {
            url {
                parameters.append("page", page.toString())
            }
        }.body()
    }
}