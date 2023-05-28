package pseudoankit.droid.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import pseudoankit.droid.preferencesmanager.PreferenceRepository

object PreferencesModule {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("tasky-prefs")

    operator fun invoke() = module {
        single { PreferenceRepository(datStore = androidContext().dataStore) }
    }
}