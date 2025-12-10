package es.mobiledev.commonandroid.ui.component.navigationBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import es.mobiledev.commonandroid.R
import es.mobiledev.navigation.AppScreens
import es.mobiledev.navigation.NavigationModule

@Composable
fun CptNavigationBar(
    selectedModule: NavigationModule,
    modifier: Modifier = Modifier,
    onClickModule: (AppScreens) -> Unit,
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = modifier,
    ) {
        val screens =
            listOf(
                AppScreens.Home,
                AppScreens.Test,
            )

        screens.forEach { screen ->
            val isSelected = selectedModule == screen.module
            CptNavigationBarItem(
                iconRes = getCurrentModuleIcon(screen.module),
                isSelected = isSelected,
                onClickModule = {
                    if (!isSelected) {
                        onClickModule(screen)
                    }
                },
            )
        }
    }
}

@Composable
private fun getCurrentModuleIcon(
    module: NavigationModule,
): Int =
    when (module) {
        NavigationModule.HOME -> R.drawable.ic_cpt_home

        NavigationModule.TEST -> R.drawable.ic_cpt_favorites_outlined

        else -> {
            R.drawable.ic_cpt_home
        }
    }
