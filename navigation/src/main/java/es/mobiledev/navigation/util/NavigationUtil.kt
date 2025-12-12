package es.mobiledev.navigation.util

import es.mobiledev.navigation.AppScreens
import es.mobiledev.navigation.NavigationModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

fun AppScreens.getCurrentSelectedModule(): StateFlow<NavigationModule> {
    val currentSelectedModule = MutableStateFlow(value = NavigationModule.HOME)
    if (this.module.hasOwnTab) {
        currentSelectedModule.update {
            this.module
        }
    }
    return currentSelectedModule
}
