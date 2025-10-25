package es.mobiledev.data.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.mobiledev.data.repository.article.ArticleRepository
import es.mobiledev.data.source.article.ArticleLocalDataSource
import es.mobiledev.data.source.article.ArticleRemoteDataSource
import es.mobiledev.domain.gateway.article.ArticleGateway

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun articleRepositoryProvider(
        articleRemoteDataSource: ArticleRemoteDataSource,
        articleLocalDataSource: ArticleLocalDataSource
    ) = ArticleRepository(
        remote = articleRemoteDataSource,
        local = articleLocalDataSource
    ) as ArticleGateway
}
