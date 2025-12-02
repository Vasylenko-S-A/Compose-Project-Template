package es.mobiledev.commonandroid.ui.component.navigationBar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import es.mobiledev.commonandroid.R

@Composable
fun RowScope.CptNavigationBarItem(
    @DrawableRes iconRes: Int,
    isSelected: Boolean,
    onClickModule: () -> Unit,
) {
    NavigationBarItem(
        selected = isSelected,
        onClick = onClickModule,
        colors =
            NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                unselectedIconColor = MaterialTheme.colorScheme.outlineVariant,
                indicatorColor = Color.Transparent,
            ),
        icon = {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = null,
            )
        },
        modifier = Modifier.height(dimensionResource(R.dimen.dp52)),
    )
}
