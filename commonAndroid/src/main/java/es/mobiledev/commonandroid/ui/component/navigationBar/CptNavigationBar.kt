package es.mobiledev.commonandroid.ui.component.navigationBar

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import es.mobiledev.commonandroid.R
import es.mobiledev.navigation.NavigationModule

@Composable
fun CptNavigationBar(
    selectedModule: NavigationModule,
    modifier: Modifier = Modifier,
    onClickModule: (NavigationModule) -> Unit,
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
        modifier = modifier,
    ) {
        val modules =
            listOf(
                NavigationModule.HOME,
                NavigationModule.TEST,
            )

        modules.forEach { module ->
            val isSelected = selectedModule == module
            CptNavigationBarItem(
                iconRes = getCurrentModuleIcon(module),
                isSelected = isSelected,
                onClickModule = {
                    if (!isSelected) {
                        onClickModule(module)
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

        NavigationModule.TEST -> R.drawable.ic_cpt_favorites

        else -> {
            R.drawable.ic_cpt_home
        }
    }
