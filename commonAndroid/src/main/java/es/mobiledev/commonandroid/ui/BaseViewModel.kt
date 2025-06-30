package es.mobiledev.commonandroid.ui

import androidx.lifecycle.ViewModel
import es.mobiledev.commonandroid.ui.components.base.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<T> : ViewModel() {
    protected abstract val uiState : MutableStateFlow<UiState<T>>

    fun getUiState(): StateFlow<UiState<T>> = uiState.asStateFlow()
}