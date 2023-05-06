package pseudoankit.droid.app_shortcuts.widget.ui

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import pseudoankit.droid.app_shortcuts.R
import pseudoankit.droid.app_shortcuts.widget.service.WidgetAgendaItemsService
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.core.deeplink.createDeeplinkIntent

fun taskyWidgetView(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val remoteViews = RemoteViews(context.packageName, R.layout.tasky_widget)
    remoteViews.setOnClickPendingIntent(
        R.id.ivAddAgenda,
        PendingIntent.getActivity(
            context,
            1,
            createDeeplinkIntent(TaskyDeeplink.agendaSelection),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
    )

    remoteViews.setRemoteAdapter(
        R.id.lvAgendaItems,
        Intent(context, WidgetAgendaItemsService::class.java)
    )

    // TODO item fix item selection
    remoteViews.setPendingIntentTemplate(
        R.id.root,
        PendingIntent.getActivity(
            context,
            appWidgetId,
            createDeeplinkIntent(TaskyDeeplink.agendaSelection),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
    )

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
}
