package es.mobiledev.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface AppScreens {
    //region TEST
    @Serializable
    data object Test : AppScreens

    @Serializable
    data object TestNavigation : AppScreens
    //endregion
}
