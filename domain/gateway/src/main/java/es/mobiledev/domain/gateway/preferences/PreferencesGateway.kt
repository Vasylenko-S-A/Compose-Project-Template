package es.mobiledev.domain.gateway.preferences

import kotlinx.coroutines.flow.Flow

interface PreferencesGateway {
    suspend fun saveLastOpenTime(time: Long)

    suspend fun getLastOpenTime(): Flow<Long>
}
