package ru.rim.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.retainedComponent
import ru.rim.project.navigation.RootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = retainedComponent {
            RootComponent(it)
        }
        setContent {
            App(
                root = root
            )
        }
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
//    App()
//}