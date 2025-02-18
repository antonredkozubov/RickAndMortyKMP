package ru.rim.project.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
fun RMCard(character: Character, onClick: () -> Unit) {
        Card(shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().height(221.dp).clickable { onClick() },
            backgroundColor = Color.Black
        ) {
            Box {
                AutoSizeImage(
                    character.image,
                    contentDescription = "image",
                )
            }
            Column(modifier = Modifier.background(AppColors.transparentBlack).padding(15.dp)) {
                Text(character.name, color = Color.White)
                Text(character.originName, color = Color.White)
                Row(modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(character.spicies, color = Color.White)
                    Text("|", color = Color.White)
                    Text(character.gender, color = Color.White)
                    Text("|", color = Color.White)
                    Text(character.status, color = Color.White)
                }
            }
        }
}