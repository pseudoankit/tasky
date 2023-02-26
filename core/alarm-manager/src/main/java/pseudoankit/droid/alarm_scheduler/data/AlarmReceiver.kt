package pseudoankit.droid.alarm_scheduler.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.koin.java.KoinJavaComponent.inject
import pseudoankit.droid.alarm_scheduler.domain.model.Alarm
import pseudoankit.droid.core.logger.TaskyLogger
import pseudoankit.droid.core.util.extension.getParcelableData
import pseudoankit.droid.notification_manager.TaskyNotifier
import pseudoankit.droid.notification_manager.TaskyNotifierConfig

internal class AlarmReceiver : BroadcastReceiver() {

    private val taskyNotifier: TaskyNotifier by inject(TaskyNotifier::class.java)

    companion object {
        private const val ALARM_ARG = "alarm"
        fun instance(context: Context, alarm: Alarm): Intent {
            return Intent(context, AlarmReceiver::class.java).apply {
                putExtra(ALARM_ARG, alarm)
            }
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val alarm = intent?.extras?.getParcelableData<Alarm>(ALARM_ARG) ?: return

        TaskyLogger.info("triggering alarm", alarm.toString())
        taskyNotifier.displayNotification(
            TaskyNotifierConfig(
                description = alarm.title,
                priority = TaskyNotifierConfig.Priority.High,
                source = alarm.source
            )
        )
    }
}
