package es.mobiledev.feature.home.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.mobiledev.commonandroid.ui.base.BaseViewModel
import es.mobiledev.commonandroid.ui.base.UiState
import es.mobiledev.domain.model.article.ArticleBo
import es.mobiledev.domain.usecase.article.GetArticlesUseCase
import es.mobiledev.domain.usecase.article.GetFavoriteArticlesUseCase
import es.mobiledev.domain.usecase.article.SaveOrRemoveFavoriteArticleUseCase
import es.mobiledev.domain.usecase.preferences.GetLastOpenTimeUseCase
import es.mobiledev.domain.usecase.preferences.SaveLastOpenTimeUseCase
import es.mobiledev.feature.home.state.HomeUiState
import kotlinx.coroutines.Dispatchers
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
        private val saveOrRemoveFavoriteArticleUseCase: SaveOrRemoveFavoriteArticleUseCase,
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

        private suspend fun saveLastOpenTime() =
            saveLastOpenTimeUseCase(Instant.now().toEpochMilli()).collectLatest {
                getLastOpenTime()
            }

        private suspend fun getLastOpenTime() =
            getLastOpenTimeUseCase().collectLatest { lastOpenTime ->
                // TODO: Pending to handle errors
                Log.d("HomeViewModel", "Last open time: $lastOpenTime")
            }

        fun getFavoriteArticles() =
            viewModelScope.launch(Dispatchers.IO) {
                getFavoriteArticlesUseCase().collectLatest { favoriteArticles ->
                    uiState.updateState { currentUiState ->
                        currentUiState.copy(
                            favoriteArticles = favoriteArticles,
                        )
                    }
                }
            }

        fun onFavoriteClick(
            article: ArticleBo,
            isFavorite: Boolean
        ) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    saveOrRemoveFavoriteArticleUseCase(article = article, isFavorite = isFavorite)
                    getFavoriteArticles()
                } catch (e: Exception) {
                    // TODO: Pending to handle errors
                    Log.e("HomeViewModel", "Error saving favorite article", e)
                }
            }
        }
    }
