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
import ru.rim.project.navigation.DetailsComponent

@Composable
fun DetailsScreen(model: Character, component: DetailsComponent) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Box {
            AutoSizeImage(
                model.image,
                contentDescription = "image",
            )
        }
        Column(modifier = Modifier.background(AppColors.transparentBlack).padding(15.dp)) {
            Text(model.name, color = Color.White)
            Text(model.originName, color = Color.White)
            Row(modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(model.spicies, color = Color.White)
                Text("|", color = Color.White)
                Text(model.gender, color = Color.White)
                Text("|", color = Color.White)
                Text(model.status, color = Color.White)
            }
        }
    }
}