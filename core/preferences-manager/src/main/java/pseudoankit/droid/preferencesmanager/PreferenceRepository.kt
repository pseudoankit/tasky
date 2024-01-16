package pseudoankit.droid.preferencesmanager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.map

class PreferenceRepository(
    datStore: DataStore<Preferences>
) : BasePreference(datStore) {

    fun isLoggedInFlow() = getValueAsFlow(Keys.isLoggedIn).map { it == true }
    suspend fun isLoggedIn() = getValue(Keys.isLoggedIn)
    suspend fun setIsLoggedIn(value: Boolean) = setValue(Keys.isLoggedIn, value)
}