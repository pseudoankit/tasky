package pseudoankit.droid.app_widgets.agenda_items

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class AgendaItemAppWidgetReceiver : GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget
        get() = AgendaItemsAppWidget

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        val appWidgetManager = AppWidgetManager.getInstance(context)
        val componentName =
            ComponentName(context.packageName, checkNotNull(javaClass.canonicalName))
        onUpdate(
            context,
            appWidgetManager,
            appWidgetManager.getAppWidgetIds(componentName),
        )
    }

    companion object {
        fun sendAppsUpdatedBroadcast(context: Context) {
            context.sendBroadcast(
                Intent(context, AgendaItemAppWidgetReceiver::class.java)
            )
        }
    }
}
