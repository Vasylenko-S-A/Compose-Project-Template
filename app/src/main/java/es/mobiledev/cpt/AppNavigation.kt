package es.mobiledev.cpt

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import es.mobiledev.commonandroid.ui.base.ScreenWrapper
import es.mobiledev.commonandroid.ui.component.navigationBar.CptNavigationBar
import es.mobiledev.commonandroid.ui.component.topBar.CptTopBar
import es.mobiledev.commonandroid.util.EmptyComposable
import es.mobiledev.cpt.ui.screen.testNavigation.TestScreen
import es.mobiledev.feature.home.screen.HomeScreen
import es.mobiledev.feature.launcher.screen.LauncherScreen
import es.mobiledev.navigation.AppScreens
import es.mobiledev.navigation.NavigationModule

/**
 * Application Navigation Graph
 *
 * This composable defines the main navigation graph of the application, handling the routing between different screens.
 * It also manages the visibility and state of the global UI elements like the TopBar and NavigationBar (BottomBar),
 * integrating them with the [ScreenWrapper].
 *
 * @param navController the [NavHostController] used to manage the app's navigation. Defaults to [rememberNavController].
 */
@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    var currentScreen: AppScreens by remember { mutableStateOf(AppScreens.Launcher) }
    val currentSelectedModule by remember { derivedStateOf { currentScreen.module } }
    val showTopAppBar by remember { derivedStateOf { currentScreen.hasTopBar } }
    val showBottomBar by remember { derivedStateOf { currentScreen.hasBottomBar } }
    val topBar: @Composable () -> Unit =
        if (showTopAppBar) {
            { CptTopBar() }
        } else {
            EmptyComposable
        }

    val bottomBar: @Composable () -> Unit =
        if (showBottomBar) {
            {
                CptNavigationBar(
                    selectedModule = currentSelectedModule,
                    modifier = Modifier,
                    onClickModule = { module ->
                        when (module) {
                            NavigationModule.LAUNCHER -> { /* no-op */ }

                            NavigationModule.HOME -> {
                                navController.navigate(AppScreens.Home) {
                                    popUpTo<AppScreens.Home> {
                                        inclusive = true
                                    }
                                }
                            }

                            NavigationModule.TEST -> {
                                navController.navigate(AppScreens.Test) {
                                    popUpTo<AppScreens.Test> {
                                        inclusive = false
                                    }
                                }
                            }
                        }
                    },
                )
            }
        } else {
            EmptyComposable
        }

    ScreenWrapper(
        topBar = topBar,
        bottomBar = bottomBar,
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = AppScreens.Launcher,
            modifier =
                Modifier
                    .padding(paddingValues)
                    .let { modifier ->
                        if (showTopAppBar) {
                            modifier.consumeWindowInsets(WindowInsets.statusBars)
                        } else {
                            modifier
                        }
                    },
        ) {
            composable<AppScreens.Launcher> { navBackStackEntry ->
                currentScreen = navBackStackEntry.toRoute<AppScreens.Launcher>()
                LauncherScreen(
                    onLauncherFinished = {
                        navController.navigate(
                            route = AppScreens.Home,
                            builder = {
                                popUpTo(navBackStackEntry.destination.id) {
                                    inclusive = true
                                }
                            },
                        )
                    },
                )
            }
            composable<AppScreens.Home> { navBackStackEntry ->
                currentScreen = navBackStackEntry.toRoute<AppScreens.Home>()
                HomeScreen(
                    navigateToTestNavigation = {
                        navController.navigate(AppScreens.Test)
                    },
                )
            }
            composable<AppScreens.Test> { navBackStackEntry ->
                currentScreen = navBackStackEntry.toRoute<AppScreens.Test>()
                TestScreen()
            }
        }
    }
}
