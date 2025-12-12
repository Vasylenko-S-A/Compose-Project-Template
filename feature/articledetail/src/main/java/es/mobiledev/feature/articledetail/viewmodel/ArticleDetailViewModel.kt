package es.mobiledev.feature.articledetail.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import es.mobiledev.commonandroid.ui.base.BaseViewModel
import es.mobiledev.commonandroid.ui.base.UiState
import es.mobiledev.domain.model.article.ArticleBo
import es.mobiledev.domain.usecase.article.GetArticleByIdUseCase
import es.mobiledev.domain.usecase.article.IsArticleFavoriteUseCase
import es.mobiledev.domain.usecase.article.SaveOrRemoveFavoriteArticleUseCase
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
        private val isArticleFavoriteUseCase: IsArticleFavoriteUseCase,
        private val saveOrRemoveFavoriteArticleUseCase: SaveOrRemoveFavoriteArticleUseCase,
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
            isArticleFavorite(args.id)
            getArticle(args.id)
        }

        private suspend fun isArticleFavorite(id: Long) =
            isArticleFavoriteUseCase(id = id).collectLatest { isFavorite ->
                uiState.updateState { currentUiState ->
                    currentUiState.copy(
                        isFavorite = isFavorite
                    )
                }
            }

        private suspend fun getArticle(id: Long) =
            getArticleByIdUseCase(id = id).collectLatest { article ->
                uiState.successState { currentUiState ->
                    currentUiState.copy(
                        article = article
                    )
                }
            }

        fun onFavoriteClick(
            article: ArticleBo,
            isFavorite: Boolean
        ) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    saveOrRemoveFavoriteArticleUseCase(
                        article = article,
                        isFavorite = isFavorite
                    )
                    uiState.successState { currentUiState ->
                        currentUiState.copy(
                            isFavorite = !isFavorite
                        )
                    }
                } catch (e: Exception) {
                    Log.e("ArticleDetailViewModel", "Error", e)
                }
            }
        }
    }
