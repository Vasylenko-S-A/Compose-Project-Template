package es.mobiledev.feature.home.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.mobiledev.commonandroid.R
import es.mobiledev.commonandroid.ui.base.BaseViewModel
import es.mobiledev.commonandroid.ui.base.UiState
import es.mobiledev.domain.model.article.ArticleBo
import es.mobiledev.domain.usecase.article.GetArticlesUseCase
import es.mobiledev.domain.usecase.article.GetFavoriteArticlesUseCase
import es.mobiledev.domain.usecase.article.RemoveFavoriteArticleUseCase
import es.mobiledev.domain.usecase.article.SaveFavoriteArticleUseCase
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
        private val getFavoriteArticlesUseCase: GetFavoriteArticlesUseCase,
        private val saveFavoriteArticleUseCase: SaveFavoriteArticleUseCase,
        private val removeFavoriteArticleUseCase: RemoveFavoriteArticleUseCase,
    ) : BaseViewModel<HomeUiState>() {
        override val uiState: MutableStateFlow<UiState<HomeUiState>> = MutableStateFlow(value = UiState(data = HomeUiState()))

        init {
            viewModelScope.launch(Dispatchers.IO) {
                fetchData()
            }
        }

        suspend fun fetchData() {
            uiState.loadingState()
            delay(2000L)
            getFavoriteArticles()
            getArticles()
        }

        private suspend fun getArticles() =
            getArticlesUseCase(limit = 5L, offset = 0L).collectLatest { articles ->
                uiState.successState { currentUiState ->
                    currentUiState.copy(
                        articles = articles
                    )
                }
            }

        private suspend fun getFavoriteArticles() =
            getFavoriteArticlesUseCase().collectLatest { favoriteArticles ->
                uiState.updateState { currentUiState ->
                    currentUiState.copy(
                        favoriteArticles = favoriteArticles,
                    )
                }
            }

        fun saveFavoriteArticle(article: ArticleBo) {
            viewModelScope.launch(Dispatchers.IO) {
                saveFavoriteArticleUseCase(article = article).collectLatest { isSaved ->
                    if (isSaved) {
                        getFavoriteArticles()
                    } else {
                        Log.e("HomeViewModel", "Error saving favorite article")
                    }
                }
            }
        }

        fun removeFavoriteArticle(article: ArticleBo) {
            viewModelScope.launch(Dispatchers.IO) {
                removeFavoriteArticleUseCase(article = article).collectLatest { isRemoved ->
                    if (isRemoved) {
                        getFavoriteArticles()
                    } else {
                        Log.e("HomeViewModel", "Error removing favorite article")
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
