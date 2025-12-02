package es.mobiledev.commonandroid.ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.mobiledev.commonandroid.ui.component.navigationBar.CptNavigationBar
import es.mobiledev.commonandroid.ui.component.topBar.CptTopBar
import es.mobiledev.commonandroid.util.EmptyComposable
import es.mobiledev.navigation.NavigationModule

/**
 * CPT design component
 *
 * ScreenWrapper implements the basic structure of the visual design that fits the “edge-to-edge” design.
 *
 * This component provides a foundation to simplify the task of building your screen and managing its states.
 * @param modifier the [Modifier] to be applied to this component
 * @param hasTopBar a flag that indicates if the top bar should be shown
 * @param hasBottomBar a flag that indicates if the bottom bar should be shown
 * @param selectedModule the [NavigationModule] currently selected in the bottom bar (if shown)
 * @param onClickModule callback to be invoked when a navigation module is selected
 * @param content content of the screen. The lambda receives a [PaddingValues] that should be
 *   applied to the content root via [Modifier.padding] to properly offset top and bottom bars.
 *   If using [Modifier.verticalScroll], apply this modifier to the child of the scroll, and not
 *   on the scroll itself.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenWrapper(
    modifier: Modifier = Modifier,
    hasTopBar: Boolean,
    hasBottomBar: Boolean,
    selectedModule: NavigationModule,
    onClickModule: (NavigationModule) -> Unit = {},
    content: @Composable ((PaddingValues) -> Unit) = {},
) {
    val topBar: @Composable () -> Unit =
        if (hasTopBar) {
            { CptTopBar() }
        } else {
            EmptyComposable
        }

    val bottomBar: @Composable () -> Unit =
        if (hasBottomBar) {
            {
                CptNavigationBar(
                    selectedModule = selectedModule,
                    modifier = Modifier,
                    onClickModule = onClickModule,
                )
            }
        } else {
            EmptyComposable
        }

    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        contentWindowInsets = calculateWindowInsets(topBar, bottomBar),
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        content(paddingValues)
    }
}

@Composable
private fun calculateWindowInsets(
    topBar: @Composable (() -> Unit),
    bottomBar: @Composable (() -> Unit),
) = when {
    topBar == EmptyComposable && bottomBar == EmptyComposable -> WindowInsets()
    topBar == EmptyComposable -> WindowInsets.navigationBars
    bottomBar == EmptyComposable -> WindowInsets.statusBars
    else -> WindowInsets.systemBars
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        ScreenWrapper(
            hasTopBar = true,
            hasBottomBar = true,
            selectedModule = NavigationModule.HOME,
            onClickModule = { },
        ) { paddingValues ->
            Box(
                contentAlignment = Alignment.Center,
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
            ) {
                Text("Hello Android!")
            }
        }
    }
}
