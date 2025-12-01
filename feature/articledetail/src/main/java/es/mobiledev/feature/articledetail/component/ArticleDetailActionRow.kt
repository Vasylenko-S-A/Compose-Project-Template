package es.mobiledev.feature.articledetail.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import es.mobiledev.commonandroid.R
import es.mobiledev.domain.model.article.ArticleBo

@Composable
fun ArticleDetailActionRow(
    article: ArticleBo,
    onFavoriteClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = article.newsSite,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.weight(weight = 1F)
        )
        IconButton(
            onClick = {
                // TODO Share content
            },
            modifier = Modifier.size(size = dimensionResource(R.dimen.article_detail_action_row__icon_button__size)),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = null
            )
        }
        Spacer(
            modifier =
                Modifier
                    .width(width = dimensionResource(R.dimen.article_detail_action_row__spacer_width))
        )
        IconButton(
            onClick = onFavoriteClick,
            modifier = Modifier.size(size = dimensionResource(R.dimen.article_detail_action_row__icon_button__size)),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_not_favorite),
                contentDescription = null
            )
        }
    }
}
