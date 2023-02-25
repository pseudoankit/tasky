package pseudoankit.droid.alarm_scheduler.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import pseudoankit.droid.alarm_scheduler.domain.model.Alarm
import pseudoankit.droid.alarm_scheduler.util.Constant
import pseudoankit.droid.core.logger.TaskyLogger
import pseudoankit.droid.core.util.extension.getParcelableData

internal class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val data =
            intent?.extras?.getParcelableData<Alarm>(Constant.Arguments.ALARM) ?: return

        // TODO notification and navigation
        TaskyLogger.log("triggering alarm", data.toString())
    }
}