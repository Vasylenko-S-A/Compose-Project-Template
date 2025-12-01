package es.mobiledev.feature.articledetail.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import es.mobiledev.commonandroid.ui.base.BaseViewModel
import es.mobiledev.commonandroid.ui.base.UiState
import es.mobiledev.domain.usecase.article.GetArticleByIdUseCase
import es.mobiledev.feature.articledetail.state.ArticleDetailUiState
import es.mobiledev.navigation.AppScreens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel
    @Inject
    constructor(
        private val getArticleByIdUseCase: GetArticleByIdUseCase,
        savedStateHandle: SavedStateHandle
    ) : BaseViewModel<ArticleDetailUiState>() {
        val args = savedStateHandle.toRoute<AppScreens.ArticleDetail>()
        override val uiState: MutableStateFlow<UiState<ArticleDetailUiState>> = MutableStateFlow(value = UiState(data = ArticleDetailUiState()))

        init {
            viewModelScope.launch(Dispatchers.IO) {
                fetchData()
            }
        }

        suspend fun fetchData() {
            uiState.loadingState()
            getArticle(args.id)
        }

        private suspend fun getArticle(id: Long) =
            getArticleByIdUseCase(id = id).collectLatest { article ->
                uiState.successState { currentUiState ->
                    currentUiState.copy(
                        article = article
                    )
                }
            }
    }
