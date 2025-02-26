package ru.rim.project.feature.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.ui.AutoSizeImage
import ru.rim.project.designsystem.theme.AppColors
import ru.rim.project.domain.model.Character

@Composable
fun DetailsScreen(model: Character, component: DetailsComponent) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(model.name) },
                    navigationIcon = {
                        IconButton(onClick = { component.goBack() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(MaterialTheme.colors.background)
            ) {
                Box {
                    AutoSizeImage(
                        model.image,
                        contentDescription = "image",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Column(modifier = Modifier
                    .background(AppColors.transparentBlack)
                    .padding(15.dp)) {
                    Text(model.name, color = Color.White)
                    Text(model.originName, color = Color.White)
                    Row(
                        modifier = Modifier.fillMaxSize(),
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
}