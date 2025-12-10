package es.mobiledev.commonandroid.ui.component.topBar

import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import es.mobiledev.commonandroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CptTopBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(R.drawable.topbar_cpt_title),
                contentDescription = null,
            )
        },
        navigationIcon = {
            IconButton(
                onClick = { /* TODO: Add navigation */ },
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_cpt_drawer),
                    contentDescription = null,
                )
            }
        },
        modifier = modifier,
    )
}

@PreviewLightDark
@Composable
private fun Preview() {
    CptTopBar(
        modifier = Modifier,
    )
}
