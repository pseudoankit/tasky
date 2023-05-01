package pseudoankit.droid.app_shortcuts.widget.ui

import android.appwidget.AppWidgetManager
import android.content.Context
import android.view.LayoutInflater
import android.widget.RemoteViews
import pseudoankit.droid.app_shortcuts.databinding.TaskyWidgetBinding

fun taskyWidgetView(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val view = TaskyWidgetBinding.inflate(LayoutInflater.from(context))
    val remoteViews = RemoteViews(context.packageName, view.root.id)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
}
