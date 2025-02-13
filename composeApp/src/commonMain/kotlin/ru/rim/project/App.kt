package ru.rim.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.rim.project.designsystem.component.RMCard
import ru.rim.project.designsystem.theme.RickAndMortyAppTheme
import ru.rim.project.domain.model.Character

@Composable
@Preview
fun App() {
    RickAndMortyAppTheme {

        val characters = remember { characterList }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(25.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            items(characters) {
                RMCard(it)
            }
        }
    }
}

var characterList = listOf( 
    Character(
    name = "Rick",
    originName = "Test",
        spicies = "Human",
    status = "Live",
    gender = "Male",
    image = "https://images.saymedia-content.com/.image/t_share/MTc0NjQ2NjMyODQ1OTQ0MTg2/rick-sanchez-character-analysis-not-a-nihilist-but-a-cynic.jpg"
), Character(
    name = "Rick",
    originName = "Test",
        spicies = "Human",
    status = "Live",
    gender = "Male",
    image = "https://images.saymedia-content.com/.image/t_share/MTc0NjQ2NjMyODQ1OTQ0MTg2/rick-sanchez-character-analysis-not-a-nihilist-but-a-cynic.jpg"),
    Character(
        name = "Rick",
        originName = "Test",
        spicies = "Human",
        status = "Live",
        gender = "Male",
        image = "https://images.saymedia-content.com/.image/t_share/MTc0NjQ2NjMyODQ1OTQ0MTg2/rick-sanchez-character-analysis-not-a-nihilist-but-a-cynic.jpg")
)