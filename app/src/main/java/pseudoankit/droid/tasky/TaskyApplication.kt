package pseudoankit.droid.tasky

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import pseudoankit.droid.agendamanger.di.AgendaManagerModule
import pseudoankit.droid.dbmanager.di.DataBaseModule

class TaskyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        loadKoinModules()
    }

    private fun loadKoinModules() {
        startKoin {
            androidLogger()
            androidContext(this@TaskyApplication)
        }

        loadKoinModules(
            listOf(
                DataBaseModule(),
                AgendaManagerModule()
            )
        )
    }
}