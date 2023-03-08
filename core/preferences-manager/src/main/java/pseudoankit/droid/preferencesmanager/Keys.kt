package pseudoankit.droid.preferencesmanager

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

internal object Keys {
    val isLoggedIn = booleanPreferencesKey("is_logged_in")
}