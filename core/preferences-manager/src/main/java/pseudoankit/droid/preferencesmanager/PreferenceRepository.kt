package pseudoankit.droid.preferencesmanager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.map
import pseudoankit.droid.di.PreferencesModule.dataStore

class PreferenceRepository(
    datStore: DataStore<Preferences>
) : BasePreference(datStore) {

    fun isLoggedIn() = getValueAsFlow(Keys.isLoggedIn).map { it == true }
    suspend fun setIsLoggedIn(value: Boolean) = setValue(Keys.isLoggedIn, value)

    companion object {
        fun create(context: Context) = PreferenceRepository(context.dataStore)
    }
}