package pseudoankit.droid.notification_manager

import android.app.Notification
import android.app.NotificationChannel
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import pseudoankit.droid.core.deeplink.DeepLinkUtil.createDeeplinkIntent
import pseudoankit.droid.unify.utils.UnifyDrawable

class TaskyNotifier(
    private val appContext: Context
) {
    companion object {
        private const val CHANNEL_ID = "tasky"
    }

    fun displayNotification(config: TaskyNotifierConfig) {
        val notification = config.createNotification()
        val notificationManager = config.createNotificationManager()
        notificationManager.notify(config.notificationId, notification)
    }

    private fun TaskyNotifierConfig.createNotificationManager() = NotificationManagerCompat
        .from(appContext)
        .apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                createNotificationChannel(
                    NotificationChannel(
                        CHANNEL_ID,
                        appContext.getString(R.string.app_name),
                        priority.importance
                    )
                )
            }
        }

    private fun TaskyNotifierConfig.createNotification(): Notification = run {
        val intent = createDeeplinkIntent(navigationUrl)
        val pendingIntent = PendingIntent.getActivity(
            appContext,
            1,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        NotificationCompat
            .Builder(appContext, CHANNEL_ID)
            .apply {
                setContentTitle(title)
                setContentText(description)
                priority = this@createNotification.priority.priority
                // TODO change to app icon
                setSmallIcon(UnifyDrawable.ic_notification)
                setContentIntent(pendingIntent)
            }.build()
    }
}