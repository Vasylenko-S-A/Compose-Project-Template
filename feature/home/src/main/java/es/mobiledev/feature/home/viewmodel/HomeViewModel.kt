package es.mobiledev.feature.home.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.mobiledev.commonandroid.ui.base.BaseViewModel
import es.mobiledev.commonandroid.ui.base.UiState
import es.mobiledev.domain.model.article.ArticleBo
import es.mobiledev.domain.usecase.article.GetArticlesUseCase
import es.mobiledev.domain.usecase.article.GetFavoriteArticlesUseCase
import es.mobiledev.domain.usecase.article.RemoveFavoriteArticleUseCase
import es.mobiledev.domain.usecase.article.SaveFavoriteArticleUseCase
import es.mobiledev.domain.usecase.preferences.GetLastOpenTimeUseCase
import es.mobiledev.domain.usecase.preferences.SaveLastOpenTimeUseCase
import es.mobiledev.feature.home.state.HomeUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.Instant
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val getArticlesUseCase: GetArticlesUseCase,
        private val getFavoriteArticlesUseCase: GetFavoriteArticlesUseCase,
        private val saveFavoriteArticleUseCase: SaveFavoriteArticleUseCase,
        private val removeFavoriteArticleUseCase: RemoveFavoriteArticleUseCase,
        private val saveLastOpenTimeUseCase: SaveLastOpenTimeUseCase,
        private val getLastOpenTimeUseCase: GetLastOpenTimeUseCase,
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
            saveLastOpenTime()
        }

        private suspend fun getArticles() =
            getArticlesUseCase(limit = 5L, offset = 0L).collectLatest { response ->
                uiState.successState { currentUiState ->
                    currentUiState.copy(
                        articles = response.results
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

        private suspend fun saveLastOpenTime() =
            saveLastOpenTimeUseCase(Instant.now().toEpochMilli()).collectLatest {
                getLastOpenTime()
            }

        private suspend fun getLastOpenTime() =
            getLastOpenTimeUseCase().collectLatest { lastOpenTime ->
                // TODO: Pending to handle errors
                Log.d("HomeViewModel", "Last open time: $lastOpenTime")
            }

        fun saveFavoriteArticle(article: ArticleBo) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    saveFavoriteArticleUseCase(article = article)
                    getFavoriteArticles()
                } catch (e: Exception) {
                    // TODO: Pending to handle errors
                    Log.e("HomeViewModel", "Error saving favorite article", e)
                }
            }
        }

        fun removeFavoriteArticle(article: ArticleBo) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    removeFavoriteArticleUseCase(article = article)
                    getFavoriteArticles()
                } catch (e: Exception) {
                    // TODO: Pending to handle errors
                    Log.e("HomeViewModel", "Error removing favorite article", e)
                }
            }
        }
    }
