package es.mobiledev.commonandroid.ui.components.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ScreenContainer(
    content: @Composable () -> Unit,
) {
        Box(
            modifier =
                Modifier.fillMaxSize(),
        ) {
            content()
        }
}