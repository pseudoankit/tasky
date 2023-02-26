package pseudoankit.droid.core.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import pseudoankit.droid.core.R

// TODO remove
class TaskyNotifier(
    private val app: Application
) {
    companion object {
        private const val CHANNEL_ID = "tasky"
    }

    val notificationBuilder = NotificationCompat.Builder(app, CHANNEL_ID)
        .setContentTitle("Title")
        .setContentText("Content Text")
        .setSmallIcon(android.R.drawable.ic_notification_overlay)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    val notificationManager = NotificationManagerCompat.from(app).also {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            it.createNotificationChannel(
                NotificationChannel(
                    CHANNEL_ID,
                    "Tasky",
                    NotificationManager.IMPORTANCE_HIGH
                )
            )
        }
    }
}