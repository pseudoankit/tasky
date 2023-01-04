package pseudoankit.droid.preferencesmanager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

abstract class BasePreference(
    val prefDataStore: DataStore<Preferences>
) {

    suspend inline fun <reified T> setValue(key: Preferences.Key<T>, value: T) {
        prefDataStore.edit {
            it[key] = value
        }
    }

    suspend inline fun <reified T> getValue(key: Preferences.Key<T>): T? {
        return getValueAsFlow(key).firstOrNull()
    }

    inline fun <reified T> getValueAsFlow(key: Preferences.Key<T>): Flow<T?> {
        return prefDataStore.data
            .catch {
                emptyPreferences()
            }
            .map { prefs ->
                prefs[key]
            }
    }
}