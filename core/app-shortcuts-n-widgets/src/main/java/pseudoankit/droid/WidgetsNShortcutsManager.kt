package pseudoankit.droid

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import pseudoankit.droid.app_shortcuts.TaskyShortCutManager
import pseudoankit.droid.app_widgets.agenda_items.AgendaItemAppWidgetReceiver
import pseudoankit.droid.core.logger.TaskyLogger
import pseudoankit.droid.core.widget.UpdateAppWidgetFlow
import pseudoankit.droid.core.widget.UpdateAppWidgetFlowNamed

object WidgetsNShortcutsManager {

    private val widgetUpdateFlow: UpdateAppWidgetFlow by inject(
        MutableSharedFlow::class.java,
        UpdateAppWidgetFlowNamed
    )

    fun initialize(context: Context) {
        TaskyShortCutManager.initialize(context)

        CoroutineScope(Dispatchers.IO).launch {
            widgetUpdateFlow.collect {
                TaskyLogger.info("updating widget")
                AgendaItemAppWidgetReceiver.sendAppsUpdatedBroadcast(context)
            }
        }
    }
}
