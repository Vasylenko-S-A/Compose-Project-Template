package es.mobiledev.feature.launcher.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import es.mobiledev.feature.launcher.R

@Composable
fun LauncherScreenContent(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
        modifier,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher),
            contentDescription = null,
            modifier =
                Modifier
                    .align(Alignment.Center),
        )
    }
}
