package es.mobiledev.data.source.preferences

interface PreferencesDataSource {
    fun saveLastOpenTime(timeInMillis: Long): Boolean

    fun getLastOpenTime(): Long
}
