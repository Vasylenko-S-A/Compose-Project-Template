package es.mobiledev.commonandroid.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<T> : ViewModel() {
    protected abstract val uiState: MutableStateFlow<UiState<T>>

    fun getUiState(): StateFlow<UiState<T>> = uiState.asStateFlow()

    fun MutableStateFlow<UiState<T>>.updateState(block: (T) -> T) {
        update { currentUiState ->
            currentUiState.copy(data = block(currentUiState.data))
        }
    }

    fun MutableStateFlow<UiState<T>>.loadingState() {
        update { currentUiState ->
            currentUiState.copy(isLoading = true)
        }
    }

    fun MutableStateFlow<UiState<T>>.successState(block: (T) -> T) {
        update { currentUiState ->
            currentUiState.copy(data = block(currentUiState.data), isLoading = false)
        }
    }
}
