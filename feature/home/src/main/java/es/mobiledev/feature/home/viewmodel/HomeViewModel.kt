package es.mobiledev.feature.home.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.mobiledev.commonandroid.R
import es.mobiledev.commonandroid.ui.base.BaseViewModel
import es.mobiledev.commonandroid.ui.base.UiState
import es.mobiledev.domain.usecase.article.GetArticlesUseCase
import es.mobiledev.feature.home.state.HomeUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getArticlesUseCase: GetArticlesUseCase,
    ) : BaseViewModel<HomeUiState>() {
        override val uiState: MutableStateFlow<UiState<HomeUiState>> = MutableStateFlow(value = UiState(data = HomeUiState()))

        init {
            viewModelScope.launch(Dispatchers.Main) {
                uiState.loadingState()
                delay(2000L)
                uiState.successState { currentUiState ->
                    currentUiState
                }
            }
            getArticles()
        }

        fun getArticles() {
            viewModelScope.launch(Dispatchers.Main) {
                getArticlesUseCase(limit = 5L, offset = 0L).collectLatest { articles ->
                    uiState.successState { currentUiState ->
                        currentUiState.copy(
                            articles = articles
                        )
                    }
                }
            }
        }

        fun onHomeButtonClick() {
            viewModelScope.launch(Dispatchers.Main) {
                uiState.updateState { currentUiState ->
                    currentUiState.copy(
                        isSubmitting = true
                    )
                }
                delay(2000L)
                uiState.successState { currentUiState ->
                    currentUiState.copy(
                        message = R.string.welcome_home,
                        buttonText = R.string.heart_emoji,
                        isSubmitting = false
                    )
                }
            }
        }
    }
