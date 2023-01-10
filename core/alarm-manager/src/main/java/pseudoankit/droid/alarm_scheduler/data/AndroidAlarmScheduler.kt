package pseudoankit.droid.alarm_scheduler.data

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import pseudoankit.droid.alarm_scheduler.domain.AlarmScheduler
import pseudoankit.droid.alarm_scheduler.domain.model.Alarm
import pseudoankit.droid.alarm_scheduler.util.Constant
import java.time.ZoneId

internal class AndroidAlarmScheduler(
    private val context: Context
) : AlarmScheduler {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    override fun schedule(alarm: Alarm) {
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra(Constant.Arguments.ALARM, alarm)
        }

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            alarm.time.atZone(ZoneId.systemDefault()).toEpochSecond().times(1000),
            PendingIntent.getBroadcast(
                context,
                alarm.uniqueId,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }

    override fun cancel(alarm: Alarm) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                alarm.uniqueId,
                Intent(),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }
}