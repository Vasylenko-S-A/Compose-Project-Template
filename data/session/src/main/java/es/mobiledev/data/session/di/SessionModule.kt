package es.mobiledev.data.session.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.mobiledev.data.session.preferences.PreferencesDataSourceImpl
import es.mobiledev.data.source.preferences.PreferencesDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SessionModule {
    @Provides
    @Singleton
    fun preferencesDataSourceProvider() = PreferencesDataSourceImpl() as PreferencesDataSource
}
