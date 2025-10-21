package es.mobiledev.domain.usecase.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.mobiledev.domain.usecase.article.GetArticlesUseCase
import es.mobiledev.domain.usecase.article.GetArticlesUseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    // TODO: Pending implementation of the RepositoryModule to use ArticleGateway

/*    @Provides
    fun getArticlesUseCaseProvider(articlesGateway: ArticleGateway): GetArticlesUseCase = GetArticlesUseCaseImpl(articlesGateway) as GetArticlesUseCase*/

    @Provides
    fun getArticlesUseCaseProvider(): GetArticlesUseCase = GetArticlesUseCaseImpl() as GetArticlesUseCase
}
