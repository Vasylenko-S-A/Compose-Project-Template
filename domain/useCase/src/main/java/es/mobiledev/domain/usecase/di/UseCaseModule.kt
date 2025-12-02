package es.mobiledev.domain.usecase.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.gateway.preferences.PreferencesGateway
import es.mobiledev.domain.usecase.article.GetArticleByIdUseCase
import es.mobiledev.domain.usecase.article.GetArticleByIdUseCaseImpl
import es.mobiledev.domain.usecase.article.GetArticlesUseCase
import es.mobiledev.domain.usecase.article.GetArticlesUseCaseImpl
import es.mobiledev.domain.usecase.article.GetFavoriteArticlesUseCase
import es.mobiledev.domain.usecase.article.GetFavoriteArticlesUseCaseImpl
import es.mobiledev.domain.usecase.article.IsArticleFavoriteUseCase
import es.mobiledev.domain.usecase.article.IsArticleFavoriteUseCaseImpl
import es.mobiledev.domain.usecase.article.RemoveFavoriteArticleUseCase
import es.mobiledev.domain.usecase.article.RemoveFavoriteArticleUseCaseImpl
import es.mobiledev.domain.usecase.article.SaveFavoriteArticleUseCase
import es.mobiledev.domain.usecase.article.SaveFavoriteArticleUseCaseImpl
import es.mobiledev.domain.usecase.article.SaveOrRemoveFavoriteArticleUseCase
import es.mobiledev.domain.usecase.article.SaveOrRemoveFavoriteArticleUseCaseImpl
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
    fun getArticleByIdUseCaseProvider(articleGateway: ArticleGateway) = GetArticleByIdUseCaseImpl(articleGateway) as GetArticleByIdUseCase

    @Provides
    fun getFavoritesArticlesUseCaseProvider(articleGateway: ArticleGateway) = GetFavoriteArticlesUseCaseImpl(articleGateway) as GetFavoriteArticlesUseCase

    @Provides
    fun saveFavoritesArticlesUseCaseProvider(articleGateway: ArticleGateway) = SaveFavoriteArticleUseCaseImpl(articleGateway) as SaveFavoriteArticleUseCase

    @Provides
    fun removeFavoritesArticlesUseCaseProvider(articleGateway: ArticleGateway) = RemoveFavoriteArticleUseCaseImpl(articleGateway) as RemoveFavoriteArticleUseCase

    @Provides
    fun isArticleFavoriteUseCaseProvider(articleGateway: ArticleGateway) = IsArticleFavoriteUseCaseImpl(articleGateway) as IsArticleFavoriteUseCase

    @Provides
    fun saveOrRemoveFavoriteArticleUseCaseProvider(articleGateway: ArticleGateway) = SaveOrRemoveFavoriteArticleUseCaseImpl(articleGateway) as SaveOrRemoveFavoriteArticleUseCase
}
