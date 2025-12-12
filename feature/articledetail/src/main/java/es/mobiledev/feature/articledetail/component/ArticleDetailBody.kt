package es.mobiledev.feature.articledetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import es.mobiledev.commonandroid.R
import es.mobiledev.domain.model.article.ArticleBo

@Composable
fun ArticleDetailBody(article: ArticleBo) {
    Column(
        verticalArrangement =
            Arrangement.spacedBy(
                space = dimensionResource(R.dimen.article_detail_body__vertical_arrangement)
            ),
    ) {
        Text(
            text = article.title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Medium,
        )
        Text(
            text = article.summary,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Light,
        )
    }
}
