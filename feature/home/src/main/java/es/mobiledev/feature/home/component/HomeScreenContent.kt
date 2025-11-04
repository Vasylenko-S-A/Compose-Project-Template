package es.mobiledev.feature.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import es.mobiledev.commonandroid.ui.component.article.ArticleItem
import es.mobiledev.domain.model.article.ArticleBo
import es.mobiledev.feature.home.state.HomeUiState

@Composable
fun HomeScreenContent(
    uiState: HomeUiState,
    onNavigateToDetail: (Long) -> Unit,
    onFavoriteClick: (ArticleBo, Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(uiState.articles, key = { index, article -> article.id }) { index, article ->
            val isFavorite = article.id in uiState.favoriteArticles.map { it.id }
            ArticleItem(
                article = article,
                isFavorite = isFavorite,
                onItemClick = {
                    onNavigateToDetail(article.id)
                },
                onFavoriteClick = {
                    onFavoriteClick(article, isFavorite)
                }
            )
            if (index < uiState.articles.lastIndex) {
                HorizontalDivider()
            }
        }
    }
}

@Composable
@PreviewLightDark
private fun HomeScreenContentPreview() {
    // TODO: Add CPTTheme
    HomeScreenContent(
        uiState = HomeUiState(),
        onNavigateToDetail = {},
        onFavoriteClick = { _, _ -> }
    )
}
