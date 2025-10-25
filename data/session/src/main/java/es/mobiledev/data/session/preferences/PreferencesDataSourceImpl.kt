package es.mobiledev.data.session.preferences

import es.mobiledev.data.source.preferences.PreferencesDataSource

// TODO: Implement real preferences
class PreferencesDataSourceImpl : PreferencesDataSource {
    private var lastOpenTime = 0L

    override fun saveLastOpenTime(timeInMillis: Long): Boolean {
        lastOpenTime = timeInMillis
        return true
    }

    override fun getLastOpenTime(): Long = lastOpenTime
}
