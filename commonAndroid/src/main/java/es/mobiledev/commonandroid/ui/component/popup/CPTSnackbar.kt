package es.mobiledev.commonandroid.ui.component.popup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import es.mobiledev.common.DEFAULT_COMPONENT_WEIGHT
import es.mobiledev.common.EMPTY_STRING
import es.mobiledev.common.ONE_FLOAT
import es.mobiledev.common.SNACKBAR_TRANSITION_DELAY
import es.mobiledev.common.ZERO_FLOAT
import es.mobiledev.commonandroid.theme.BlueGrey300
import es.mobiledev.commonandroid.theme.BlueGrey50
import es.mobiledev.commonandroid.theme.BlueGrey800
import es.mobiledev.commonandroid.theme.BlueGrey930
import es.mobiledev.commonandroid.theme.CptTheme
import es.mobiledev.commonandroid.theme.bodySmallRoboto
import es.mobiledev.commonandroid.theme.labelLargeRoboto
import es.mobiledev.commonandroid.theme.titleMediumRoboto

@Composable
fun CPTSnackbar(
    title: String,
    message: String,
    modifier: Modifier = Modifier,
    actionLabel: String? = null,
    action: (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    leadingContent: @Composable (() -> Unit)? = null,
) {
    val transitionState =
        remember {
            MutableTransitionState(false).apply {
                targetState = true
            }
        }

    val progress = remember { Animatable(ONE_FLOAT) }

    LaunchedEffect(
        actionLabel,
        transitionState.targetState,
        transitionState.currentState
    ) {
        if ((actionLabel == null || action == null) && transitionState.targetState) {
            progress.animateTo(
                targetValue = ZERO_FLOAT,
                animationSpec =
                    tween(
                        durationMillis = SNACKBAR_TRANSITION_DELAY,
                        easing = LinearEasing
                    )
            )
            transitionState.targetState = false
        }

        if (!transitionState.targetState && !transitionState.currentState) {
            action?.invoke()
        }
    }

    AnimatedVisibility(
        visibleState = transitionState,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
    ) {
        Snackbar(
            actionOnNewLine = true,
            shape = RoundedCornerShape(24.dp),
            containerColor = BlueGrey300,
            content = {
                CPTSnackbarContent(
                    title = title,
                    message = message,
                    leadingContent = leadingContent,
                    trailingContent = trailingContent,
                    progress = progress.value.takeIf { actionLabel == null || action == null },
                )
            },
            action =
                CPTSnackbarAction(
                    actionLabel = actionLabel,
                    onAction = {
                        transitionState.targetState = false
                    },
                ).takeIf { actionLabel != null && action != null },
            modifier = modifier.padding(8.dp),
        )
    }
}

@Composable
private fun CPTSnackbarContent(
    title: String,
    message: String,
    leadingContent: @Composable (() -> Unit)?,
    trailingContent: @Composable (() -> Unit)?,
    modifier: Modifier = Modifier,
    progress: Float? = null,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        modifier =
            modifier
                .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier =
                Modifier
                    .fillMaxWidth(),
        ) {
            leadingContent?.let { safeLeadingContent ->
                safeLeadingContent()
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(DEFAULT_COMPONENT_WEIGHT),
            ) {
                Text(
                    text = title,
                    style =
                        titleMediumRoboto(
                            color = BlueGrey930,
                            fontWeight = FontWeight.Bold,
                        ),
                )
                Text(
                    text = message,
                    style =
                        bodySmallRoboto(
                            color = BlueGrey800,
                            fontWeight = FontWeight.SemiBold,
                        ),
                )
            }
            trailingContent?.let { safeTrailingContent ->
                safeTrailingContent()
            }
        }
        progress?.let { safeProgress ->
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth(safeProgress)
                        .height(3.dp)
                        .clip(CircleShape)
                        .background(BlueGrey800),
            )
        }
    }
}

@Composable
private fun CPTSnackbarAction(
    actionLabel: String?,
    onAction: () -> Unit,
): @Composable (() -> Unit) =
    {
        TextButton(
            onClick = onAction,
        ) {
            Text(
                text = actionLabel ?: EMPTY_STRING,
                style =
                    labelLargeRoboto(
                        color = BlueGrey930,
                        fontWeight = FontWeight.SemiBold,
                    ),
            )
        }
    }

@PreviewLightDark
@Composable
private fun Preview() {
    CptTheme {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(BlueGrey50)
                    .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CPTSnackbar(
                title = "Auto-dismiss",
                message = "Watch the progress bar at the bottom",
            )
            CPTSnackbar(
                title = "Persistent",
                message = "This one has an action, so no progress bar",
                actionLabel = "Confirm",
                action = {}
            )
        }
    }
}
