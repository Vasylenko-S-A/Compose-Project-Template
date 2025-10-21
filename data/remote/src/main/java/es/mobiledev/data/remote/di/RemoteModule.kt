package es.mobiledev.data.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.mobiledev.data.remote.article.ArticleRemoteDataSourceImpl
import es.mobiledev.data.remote.article.ArticleWs
import es.mobiledev.data.source.article.ArticleRemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Provides
    fun articleDataSourceProvider(articleService: ArticleWs) = ArticleRemoteDataSourceImpl(articleWs = articleService) as ArticleRemoteDataSource
}
