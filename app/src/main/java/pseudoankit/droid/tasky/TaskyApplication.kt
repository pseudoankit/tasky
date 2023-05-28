package pseudoankit.droid.tasky

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import pseudoankit.droid.app_shortcuts.TaskyShortCutManager
import pseudoankit.droid.app_widgets.agenda_items.AgendaItemAppWidgetReceiver
import pseudoankit.droid.tasky.di.AppModule

class TaskyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        loadKoinModules()
        AgendaItemAppWidgetReceiver.sendAppsUpdatedBroadcast(this)
    }

    private fun loadKoinModules() {
        startKoin {
            androidLogger()
            androidContext(this@TaskyApplication)
        }
        loadKoinModules(AppModule)
        TaskyShortCutManager.initialize(this)
    }
}