package pseudoankit.droid.alarm_scheduler.data

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import pseudoankit.droid.alarm_scheduler.domain.AlarmScheduler
import pseudoankit.droid.alarm_scheduler.domain.model.Alarm
import pseudoankit.droid.core.logger.TaskyLogger

internal class AndroidAlarmScheduler(
    private val context: Context
) : AlarmScheduler {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    override fun schedule(alarm: Alarm) {
        val intent = AlarmReceiver.instance(context, alarm)
        TaskyLogger.log("scheduling alarm", alarm.toString())

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            alarm.timeInMillis,
            createPendingIntent(alarm, intent = {
                intent
            })
        )
    }

    override fun cancel(alarm: Alarm) {
        alarmManager.cancel(
            createPendingIntent(alarm, intent = {
                Intent()
            })
        )
    }

    private fun createPendingIntent(alarm: Alarm, intent: () -> Intent): PendingIntent? {
        return PendingIntent.getBroadcast(
            context,
            alarm.id.toInt(),
            intent(),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
}