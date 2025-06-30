package es.mobiledev.cpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import es.mobiledev.commonandroid.ui.components.base.ScreenContainer
import es.mobiledev.cpt.ui.theme.CPTTheme
import es.mobiledev.home.screen.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CPTTheme {
                ScreenContainer{
                    HomeScreen()
                }
            }
        }
    }
}
