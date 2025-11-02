package es.mobiledev.feature.launcher.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import es.mobiledev.commonandroid.ui.base.BaseScreen
import es.mobiledev.feature.launcher.component.LauncherScreenContent
import es.mobiledev.feature.launcher.viewmodel.LauncherViewModel

@Composable
fun LauncherScreen(
    onLauncherFinished: () -> Unit,
) {
    val launcherViewModel: LauncherViewModel = hiltViewModel()
    val uiState by launcherViewModel.getUiState().collectAsStateWithLifecycle()

    LaunchedEffect(uiState.data.hasFinish) {
        if (uiState.data.hasFinish) {
            onLauncherFinished()
        }
    }

    BaseScreen { paddingValues ->
        LauncherScreenContent(
            modifier =
                Modifier
                    .padding(paddingValues),
        )
    }
}

@Composable
@Preview
private fun Preview() {
    LauncherScreen(
        onLauncherFinished = {},
    )
}
