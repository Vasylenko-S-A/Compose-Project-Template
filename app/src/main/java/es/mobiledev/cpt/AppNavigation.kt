package es.mobiledev.cpt

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.mobiledev.cpt.ui.screen.test.TestScreen
import es.mobiledev.cpt.ui.screen.testNavigation.TestNavigationScreen
import es.mobiledev.navigation.AppScreens

/**
 * Composable that defines the navigation graph of the application.
 *
 * @param navController The NavHostController that will be used to manage navigation.
 */
@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = AppScreens.Test) {
        composable<AppScreens.Test> {
            TestScreen(
                onTextClick = { navController.navigate(route = AppScreens.TestNavigation) },
            )
        }
        composable<AppScreens.TestNavigation> {
            TestNavigationScreen()
        }
    }
}
