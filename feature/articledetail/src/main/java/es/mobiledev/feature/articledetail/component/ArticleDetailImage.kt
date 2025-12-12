package es.mobiledev.feature.articledetail.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import es.mobiledev.commonandroid.R
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
                    shape = RoundedCornerShape(size = dimensionResource(R.dimen.article_detail_image__corner_radius))
                ),
    )
}
