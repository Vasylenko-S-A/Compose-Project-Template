package es.mobiledev.data.source.preferences

interface PreferencesDataSource {
    suspend fun saveLastOpenTime(timeInMillis: Long)

    suspend fun getLastOpenTime(): Long
}
