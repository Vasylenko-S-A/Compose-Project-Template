package es.mobiledev.data.repository.preferences

import es.mobiledev.data.source.preferences.PreferencesDataSource
import es.mobiledev.domain.gateway.preferences.PreferencesGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PreferencesRepository(
    private val preferences: PreferencesDataSource
) : PreferencesGateway {
    override suspend fun saveLastOpenTime(time: Long): Flow<Boolean> = flowOf(preferences.saveLastOpenTime(time))

    override suspend fun getLastOpenTime(): Flow<Long> = flowOf(preferences.getLastOpenTime())
}
