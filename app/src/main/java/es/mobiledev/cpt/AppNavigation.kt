package es.mobiledev.cpt

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.mobiledev.cpt.ui.screen.testNavigation.TestNavigationScreen
import es.mobiledev.feature.home.screen.HomeScreen
import es.mobiledev.feature.launcher.screen.LauncherScreen
import es.mobiledev.navigation.AppScreens

/**
 * Composable that defines the navigation graph of the application.
 *
 * @param navController The NavHostController that will be used to manage navigation.
 */
@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = AppScreens.Launcher) {
        composable<AppScreens.Launcher> { navBackStackEntry ->
            LauncherScreen(
                onLauncherFinished = {
                    navController.navigate(
                        route = AppScreens.Home,
                        builder = {
                            popUpTo(navBackStackEntry.destination.id) {
                                inclusive = true
                            }
                        }
                    )
                }
            )
        }
        composable<AppScreens.Home> {
            HomeScreen(
                navigateToTestNavigation = {
                    navController.navigate(AppScreens.TestNavigation)
                },
            )
        }
        composable<AppScreens.TestNavigation> {
            TestNavigationScreen()
        }
    }
}
