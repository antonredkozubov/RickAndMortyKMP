package ru.rim.project.feature.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.ui.AutoSizeImage
import ru.rim.project.designsystem.theme.AppColors
import ru.rim.project.domain.model.Character

@Composable
fun DetailsScreen(model: Character) {

    var characterModel = model

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Box {
            AutoSizeImage(
                characterModel.image,
                contentDescription = "image",
            )
        }
        Column(modifier = Modifier.background(AppColors.transparentBlack).padding(15.dp)) {
            Text(characterModel.name, color = Color.White)
            Text(characterModel.originName, color = Color.White)
            Row(modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(characterModel.spicies, color = Color.White)
                Text("|", color = Color.White)
                Text(characterModel.gender, color = Color.White)
                Text("|", color = Color.White)
                Text(characterModel.status, color = Color.White)
            }
        }
    }
}