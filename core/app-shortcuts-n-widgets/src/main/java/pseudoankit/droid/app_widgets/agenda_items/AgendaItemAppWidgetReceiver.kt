package pseudoankit.droid.app_widgets.agenda_items

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.state.PreferencesGlanceStateDefinition
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import org.koin.java.KoinJavaComponent.inject
import pseudoankit.droid.agendamanger.domain.repository.AgendaRepository
import pseudoankit.droid.app_widgets.util.WidgetPrefsKey
import pseudoankit.droid.core.util.defaultJsonSerializer

class AgendaItemAppWidgetReceiver : GlanceAppWidgetReceiver() {

    private val agendaRepository: AgendaRepository by inject(AgendaRepository::class.java)

    override val glanceAppWidget: GlanceAppWidget
        get() = AgendaItemsAppWidget

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        syncPrefsToDb(context)
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        syncPrefsToDb(context)
    }

    private fun syncPrefsToDb(context: Context) {
        MainScope().launch {
            val items = agendaRepository.getAllSavedItem().firstOrNull().orEmpty().map {
                WidgetAgendaItem(
                    id = it.id,
                    title = it.title
                )
            }
            val itemsJson = defaultJsonSerializer.encodeToString(items)
            val glanceId = GlanceAppWidgetManager(context)
                .getGlanceIds(AgendaItemsAppWidget::class.java)
                .firstOrNull()

            if (glanceId != null) {
                updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) { prefs ->
                    prefs.toMutablePreferences().apply {
                        this[WidgetPrefsKey.agendaItems] = itemsJson
                    }
                }
                glanceAppWidget.update(context, glanceId)
            }
        }
    }
}
