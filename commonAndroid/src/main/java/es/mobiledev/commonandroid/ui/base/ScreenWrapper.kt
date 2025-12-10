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
 * @param topBar a Composable function to provide the content for the top bar. Defaults to [EmptyComposable].
 * @param bottomBar a Composable function to provide the content for the bottom bar. Defaults to [EmptyComposable].
 * @param content content of the screen. The lambda receives a [PaddingValues] that should be
 *   applied to the content root via [Modifier.padding] to properly offset top and bottom bars.
 *   If using [Modifier.verticalScroll], apply this modifier to the child of the scroll, and not
 *   on the scroll itself.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenWrapper(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = EmptyComposable,
    bottomBar: @Composable () -> Unit = EmptyComposable,
    showTopAppBar: Boolean = false,
    showBottomBar: Boolean = false,
    content: @Composable (PaddingValues) -> Unit = { EmptyComposable },
) {
    Scaffold(
        topBar = {
            if (showTopAppBar) {
                topBar()
            }
        },
        bottomBar = {
            if (showBottomBar) {
                bottomBar()
            }
        },
        contentWindowInsets =
            when {
                showTopAppBar && showBottomBar -> WindowInsets.systemBars

                showTopAppBar -> WindowInsets.statusBars

                showBottomBar -> WindowInsets.navigationBars

                else -> WindowInsets()
            },
        modifier = modifier.fillMaxSize(),
    ) { paddingValues ->
        content(paddingValues)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        ScreenWrapper(
            topBar = { CptTopBar() },
            bottomBar = {
                CptNavigationBar(
                    selectedModule = NavigationModule.HOME,
                    modifier = Modifier,
                    onClickModule = { },
                )
            },
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
