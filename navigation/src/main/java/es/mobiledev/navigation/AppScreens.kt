package es.mobiledev.navigation

import kotlinx.serialization.Serializable

/**
 * Sealed interface that represents the different screens of the application.
 */
@Serializable
sealed interface AppScreens {
    //region TEST
    @Serializable
    data object Test : AppScreens

    @Serializable
    data object TestNavigation : AppScreens
    //endregion

    //region HOME
    @Serializable
    data object Home : AppScreens
    //endregion
}
