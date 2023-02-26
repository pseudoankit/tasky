package pseudoankit.droid.alarm_scheduler.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import pseudoankit.droid.alarm_scheduler.domain.model.Alarm
import pseudoankit.droid.core.logger.TaskyLogger
import pseudoankit.droid.core.util.extension.getParcelableData

internal class AlarmReceiver : BroadcastReceiver() {

    companion object {
        private const val ALARM_ARG = "alarm"
        fun instance(context: Context, alarm: Alarm): Intent {
            return Intent(context, AlarmReceiver::class.java).apply {
                putExtra(ALARM_ARG, alarm)
            }
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val data =
            intent?.extras?.getParcelableData<Alarm>(ALARM_ARG) ?: return

        // TODO notification and navigation
        TaskyLogger.log("triggering alarm", data.toString())
    }
}