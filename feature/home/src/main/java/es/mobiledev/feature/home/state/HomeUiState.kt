package es.mobiledev.feature.home.state

import es.mobiledev.commonandroid.R

data class HomeUiState(
    val message: Int = R.string.are_you_there,
    val buttonText: Int = R.string.im_here,
    val isSubmitting: Boolean = false
)
