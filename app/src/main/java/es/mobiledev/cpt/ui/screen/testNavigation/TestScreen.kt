package es.mobiledev.cpt.ui.screen.testNavigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import es.mobiledev.commonandroid.R
import es.mobiledev.commonandroid.ui.base.BaseScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestScreen() {
    val viewModel: TestViewModel = hiltViewModel()
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()
    BaseScreen(
        isLoading = uiState.isLoading,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(stringResource(R.string.test), color = MaterialTheme.colorScheme.onPrimary)
                },
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
            )
        },
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
