package es.mobiledev.commonandroid.ui.base

data class UiState<T>(
    val data: T,
    val isLoading: Boolean = false,
)
