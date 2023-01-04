package pseudoankit.droid.preferencesmanager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

class PreferenceRepository(
    datStore: DataStore<Preferences>
) : BasePreference(datStore) {

    suspend fun getLanguage() = getValue(Keys.Language)
    suspend fun setLanguage(value: String) = setValue(Keys.Language, value)

}