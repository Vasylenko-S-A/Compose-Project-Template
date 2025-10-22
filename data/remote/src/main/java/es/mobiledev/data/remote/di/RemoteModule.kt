package es.mobiledev.data.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.mobiledev.data.remote.article.ArticleRemoteDataSourceImpl
import es.mobiledev.data.source.article.ArticleRemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    fun articleDataSourceProvider() = ArticleRemoteDataSourceImpl() as ArticleRemoteDataSource
}
