package es.mobiledev.data.session

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import es.mobiledev.data.session.util.LAST_OPEN_TIME_DEFAULT_VALUE
import es.mobiledev.data.session.util.PrefKeys
import es.mobiledev.data.session.util.getPreference
import es.mobiledev.data.session.util.savePreference
import es.mobiledev.data.source.preferences.PreferencesDataSource

class PreferencesDataSourceImpl(
    private val preferences: DataStore<Preferences>
) : PreferencesDataSource {
    override suspend fun saveLastOpenTime(timeInMillis: Long) {
        preferences.savePreference(
            key = PrefKeys.LAST_OPEN_TIME,
            value = timeInMillis
        )
    }

    override suspend fun getLastOpenTime(): Long =
        preferences.getPreference(
            key = PrefKeys.LAST_OPEN_TIME,
            defaultValue = LAST_OPEN_TIME_DEFAULT_VALUE
        )
}
