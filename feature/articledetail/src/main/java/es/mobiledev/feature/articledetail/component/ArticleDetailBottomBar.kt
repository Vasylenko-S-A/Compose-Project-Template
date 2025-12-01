package es.mobiledev.feature.articledetail.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import es.mobiledev.commonandroid.R

@Composable
fun ArticleDetailBottomBar(
    newsUrl: String,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    BottomAppBar(
        containerColor = Color.Transparent,
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            TextButton(
                onClick = {
                    uriHandler.openUri(newsUrl)
                },
                colors =
                    ButtonDefaults.textButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                    ),
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_document),
                    contentDescription = null,
                )
                Spacer(
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.article_detail_bottom_bar__spacer_width))
                )
                Text(
                    text = stringResource(R.string.continue_reading),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
