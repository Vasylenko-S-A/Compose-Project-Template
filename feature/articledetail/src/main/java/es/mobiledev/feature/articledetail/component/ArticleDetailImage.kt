package es.mobiledev.feature.articledetail.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import es.mobiledev.commonandroid.theme.getArticleDetailShape
import es.mobiledev.domain.model.article.ArticleBo

@Composable
fun ArticleDetailImage(article: ArticleBo) {
    AsyncImage(
        contentScale = ContentScale.Crop,
        model = article.imageUrl,
        contentDescription = null,
        modifier =
            Modifier
                .aspectRatio(ratio = 16F / 9F)
                .clip(
                    shape = getArticleDetailShape()
                ),
    )
}
