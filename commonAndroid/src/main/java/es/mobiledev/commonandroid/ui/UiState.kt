package es.mobiledev.commonandroid.ui.components.base

data class UiState<T>(
    val data: T,
    val isLoading: Boolean = false,
)