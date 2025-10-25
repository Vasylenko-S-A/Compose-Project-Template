package es.mobiledev.data.local.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.mobiledev.data.local.article.datasource.ArticleLocalDataSourceImpl
import es.mobiledev.data.source.article.ArticleLocalDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {
    @Provides
    @Singleton
    fun articleLocalDataSourceProvider() = ArticleLocalDataSourceImpl() as ArticleLocalDataSource
}
