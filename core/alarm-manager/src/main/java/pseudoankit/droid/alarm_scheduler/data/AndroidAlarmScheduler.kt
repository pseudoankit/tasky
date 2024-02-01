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
        TaskyLogger.info("scheduling alarm", alarm.toString())

        createPendingIntent(alarm, intent = {
            AlarmReceiver.instance(context, alarm)
        })?.let {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                alarm.timeInMillis,
                it
            )
        }
    }

    override fun cancel(alarm: Alarm) {
        TaskyLogger.info("cancelling alarm", alarm.toString())
        createPendingIntent(alarm, intent = {
            AlarmReceiver.instance(context, alarm)
        })?.let {
            alarmManager.cancel(
                it
            )
        }
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