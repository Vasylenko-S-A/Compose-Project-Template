package es.mobiledev.domain.usecase.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.gateway.preferences.PreferencesGateway
import es.mobiledev.domain.usecase.article.GetArticlesUseCase
import es.mobiledev.domain.usecase.article.GetArticlesUseCaseImpl
import es.mobiledev.domain.usecase.article.GetFavoriteArticlesUseCase
import es.mobiledev.domain.usecase.article.GetFavoriteArticlesUseCaseImpl
import es.mobiledev.domain.usecase.article.RemoveFavoriteArticleUseCase
import es.mobiledev.domain.usecase.article.RemoveFavoriteArticleUseCaseImpl
import es.mobiledev.domain.usecase.article.SaveFavoriteArticleUseCase
import es.mobiledev.domain.usecase.article.SaveFavoriteArticleUseCaseImpl
import es.mobiledev.domain.usecase.preferences.GetLastOpenTimeUseCase
import es.mobiledev.domain.usecase.preferences.GetLastOpenTimeUseCaseImpl
import es.mobiledev.domain.usecase.preferences.SaveLastOpenTimeUseCase
import es.mobiledev.domain.usecase.preferences.SaveLastOpenTimeUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun saveLastOpenTimeUseCaseProvider(prefersGateway: PreferencesGateway) = SaveLastOpenTimeUseCaseImpl(prefersGateway) as SaveLastOpenTimeUseCase

    @Provides
    fun getLastOpenTimeUseCaseProvider(prefersGateway: PreferencesGateway) = GetLastOpenTimeUseCaseImpl(prefersGateway) as GetLastOpenTimeUseCase

    @Provides
    fun getArticlesUseCaseProvider(articleGateway: ArticleGateway) = GetArticlesUseCaseImpl(articleGateway) as GetArticlesUseCase

    @Provides
    fun getFavoritesArticlesUseCaseProvider(articleGateway: ArticleGateway) = GetFavoriteArticlesUseCaseImpl(articleGateway) as GetFavoriteArticlesUseCase

    @Provides
    fun saveFavoritesArticlesUseCaseProvider(articleGateway: ArticleGateway) = SaveFavoriteArticleUseCaseImpl(articleGateway) as SaveFavoriteArticleUseCase

    @Provides
    fun removeFavoritesArticlesUseCaseProvider(articleGateway: ArticleGateway) = RemoveFavoriteArticleUseCaseImpl(articleGateway) as RemoveFavoriteArticleUseCase
}
