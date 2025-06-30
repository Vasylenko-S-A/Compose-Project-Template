package es.mobiledev.home.viewmodel

import androidx.lifecycle.viewModelScope
import es.mobiledev.commonandroid.ui.BaseViewModel
import es.mobiledev.commonandroid.ui.components.base.UiState
import es.mobiledev.home.state.HomeUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewmodel() : BaseViewModel<HomeUiState>(){
    override val uiState: MutableStateFlow<UiState<HomeUiState>> =
        MutableStateFlow(UiState(HomeUiState()))

    init {
        viewModelScope.launch {
            uiState.update { currentState ->
                currentState.copy(
                    isLoading = true,
                )
            }
            delay(3000)
            uiState.update { currentState ->
                currentState.copy(
                    isLoading = false,
                )
            }
        }
    }
}