package pseudoankit.droid.app_shortcuts.widget.ui

import android.appwidget.AppWidgetManager
import android.content.Context
import android.widget.RemoteViews
import pseudoankit.droid.app_shortcuts.R

fun taskyWidgetView(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val remoteViews = RemoteViews(context.packageName, R.layout.tasky_widget)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
}
