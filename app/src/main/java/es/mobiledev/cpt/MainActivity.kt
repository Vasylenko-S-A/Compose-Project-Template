package es.mobiledev.cpt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import es.mobiledev.cpt.ui.theme.CPTTheme

class MainActivity : ComponentActivity() {
    private var navController: NavHostController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            navController = rememberNavController()
            navController?.let { safeNavController ->
                CPTTheme {
                    AppNavigation(
                        navController = safeNavController
                    )
                }
            }
        }
    }
}
