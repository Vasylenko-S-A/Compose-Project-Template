package es.mobiledev.domain.usecase.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.usecase.article.GetArticlesUseCase
import es.mobiledev.domain.usecase.article.GetArticlesUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun getArticlesUseCaseProvider(articleGateway: ArticleGateway) = GetArticlesUseCaseImpl(articleGateway) as GetArticlesUseCase
}
