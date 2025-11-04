package es.mobiledev.feature.launcher.viewmodel

import androidx.lifecycle.viewModelScope
import es.mobiledev.commonandroid.ui.base.BaseViewModel
import es.mobiledev.commonandroid.ui.base.UiState
import es.mobiledev.feature.launcher.state.LauncherUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LauncherViewModel
    @Inject
    constructor() : BaseViewModel<LauncherUiState>() {
        override val uiState: MutableStateFlow<UiState<LauncherUiState>> = MutableStateFlow(value = UiState(data = LauncherUiState()))

        init {
            viewModelScope.launch {
                doSomething()
            }
        }

        private suspend fun doSomething() {
            delay(3000L)
            uiState.successState { currentUiState ->
                currentUiState.copy(
                    hasFinish = true
                )
            }
        }
    }
