package pseudoankit.droid.app_widgets.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import pseudoankit.droid.app_shortcuts_n_widgets.R
import pseudoankit.droid.app_widgets.service.WidgetAgendaItemsService
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.core.deeplink.createDeeplinkIntent


/**
 * Implementation of App Widget functionality.
 */
class TaskyWidgetProvider : AppWidgetProvider() {
    companion object {
        const val EXTRA_ITEM = "widget.item"
    }

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            val remoteViews = RemoteViews(context.packageName, R.layout.tasky_widget)

            // add button
            remoteViews.setOnClickPendingIntent(
                R.id.ivAddAgenda,
                PendingIntent.getActivity(
                    context,
                    1,
                    createDeeplinkIntent(TaskyDeeplink.agendaSelection),
                    PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                )
            )

            // list items
            remoteViews.setRemoteAdapter(
                R.id.lvAgendaItems,
                Intent(context, WidgetAgendaItemsService::class.java).apply {
                    putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
                    data = Uri.parse(toUri(Intent.URI_INTENT_SCHEME))
                }
            )

            remoteViews.setPendingIntentTemplate(
                R.id.lvAgendaItems,
                PendingIntent.getActivity(
                    context,
                    0,
                    createDeeplinkIntent(TaskyDeeplink.fromWidget),
                    PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
                )
            )

            appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}
