package es.mobiledev.feature.home.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import es.mobiledev.commonandroid.R
import es.mobiledev.commonandroid.ui.base.BaseScreen
import es.mobiledev.feature.home.component.HomeScreenContent
import es.mobiledev.feature.home.component.HomeScreenTopBar
import es.mobiledev.feature.home.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    navigateToTestNavigation: () -> Unit,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    val uiState by viewModel.getUiState().collectAsStateWithLifecycle()

    BaseScreen(
        isLoading = uiState.isLoading,
        topBar = {
            HomeScreenTopBar(
                title = stringResource(R.string.home),
            )
        },
    ) { paddingValues ->
        HomeScreenContent(
            uiState = uiState.data,
            onNavigateToDetail = { id ->
                navigateToTestNavigation()
            },
            onFavoriteClick = { article, isFavorite ->
                if (isFavorite) {
                    viewModel.removeFavoriteArticle(article)
                } else {
                    viewModel.saveFavoriteArticle(article)
                }
            },
            modifier = Modifier.padding(paddingValues),
        )
    }
}

@Composable
@PreviewLightDark
fun HomeScreenPreview() {
    // TODO: Add CPTTheme
    HomeScreen(
        navigateToTestNavigation = { },
    )
}
