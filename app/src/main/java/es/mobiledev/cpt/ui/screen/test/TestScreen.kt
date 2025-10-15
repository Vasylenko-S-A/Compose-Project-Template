package es.mobiledev.cpt.ui.screen.test

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import es.mobiledev.commonandroid.ui.base.BaseScreen
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TestScreen(
    viewModel: TestViewModel = viewModel()
) {
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()
    BaseScreen(
        isLoading = uiState.isLoading,
    ) { paddingValues ->
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(uiState.data.title)
        }
    }
}
