package es.mobiledev.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import es.mobiledev.commonandroid.R
import es.mobiledev.commonandroid.ui.component.button.CPTButton
import es.mobiledev.feature.home.state.HomeUiState

@Composable
fun HomeScreenContent(
    uiState: HomeUiState,
    onHomeButtonClick: () -> Unit,
    onTestNavigationClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var hasClickedButton by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement =
            Arrangement.spacedBy(
                space = dimensionResource(id = R.dimen.home_screen__content__vertical_arrangement),
                alignment = Alignment.CenterVertically,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = uiState.message),
            style = MaterialTheme.typography.displaySmall,
        )
        CPTButton(
            onClick = {
                hasClickedButton = true
                onHomeButtonClick()
            },
            enabled = hasClickedButton.not(),
            submitting = uiState.isSubmitting,
        ) {
            Text(
                text = stringResource(id = uiState.buttonText),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        CPTButton(
            onClick = {
                onTestNavigationClick()
            },
        ) {
            Text(
                text = stringResource(id = R.string.test_navigation),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun HomeScreenContentPreview() {
    // TODO: Add CPTTheme
    HomeScreenContent(
        uiState = HomeUiState(),
        onHomeButtonClick = {},
        onTestNavigationClick = {},
    )
}
