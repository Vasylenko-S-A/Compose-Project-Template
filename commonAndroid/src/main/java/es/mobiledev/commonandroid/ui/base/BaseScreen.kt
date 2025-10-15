package es.mobiledev.commonandroid.ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * CPT design component
 *
 * BaseScreen implements the basic structure of the visual design that fits the “edge-to-edge” design.
 *
 * This component provides a foundation to simplify the task of building your screen and managing its states.
 * @param modifier the [Modifier] to be applied to this component
 * @param isLoading a flag that indicates if the screen is loading
 * @param topBar top app bar of the screen, typically a [TopAppBar]
 * @param bottomBar bottom bar of the screen, typically a [NavigationBar]
 * @param content content of the screen. The lambda receives a [PaddingValues] that should be
 *   applied to the content root via [Modifier.padding] to properly offset top and bottom bars.
 *   If using [Modifier.verticalScroll], apply this modifier to the child of the scroll, and not
 *   on the scroll itself.
 */
@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    topBar: @Composable (() -> Unit) = {},
    bottomBar: @Composable (() -> Unit) = {},
    content: @Composable ((PaddingValues) -> Unit) = {},
) {
    Scaffold(
        topBar = topBar,
        bottomBar = bottomBar,
        contentWindowInsets = calculateWindowInsets(topBar, bottomBar),
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        if (isLoading) {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        } else {
            content(paddingValues)
        }
    }
}

@Composable
private fun calculateWindowInsets(
    topBar: @Composable (() -> Unit),
    bottomBar: @Composable (() -> Unit)
) = when {
    topBar == {} && bottomBar == {} -> WindowInsets()
    topBar == {} -> WindowInsets.navigationBars
    bottomBar == {} -> WindowInsets.statusBars
    else -> WindowInsets.systemBars
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun Preview() {
    MaterialTheme {
        BaseScreen(
            topBar = {
                TopAppBar(
                    title = { Text("Preview") },
                    colors =
                        TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                        )
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ) {}
            },
        ) { paddingValues ->
            Box(
                contentAlignment = Alignment.Center,
                modifier =
                    Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
            ) {
                Text("Hello Android!")
            }
        }
    }
}
