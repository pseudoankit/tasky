package pseudoankit.droid.agendamanger.domain.usecase.reminder

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.alarm_scheduler.domain.AlarmScheduler
import pseudoankit.droid.alarm_scheduler.domain.model.Alarm
import pseudoankit.droid.notification_manager.TaskyNotifierConfig
import java.time.LocalDateTime
import java.time.LocalTime

internal class TriggerAlarmUseCase(
    private val alarmScheduler: AlarmScheduler
) {

    operator fun invoke(payload: AgendaItem.Reminder, alarmDeepLink: String) {
        val time = when (payload.time) {
            AgendaItem.Reminder.Time.AllDay -> LocalTime.NOON
            is AgendaItem.Reminder.Time.Time -> payload.time.value.value
        }

        val alarm = Alarm(
            localDateTime = LocalDateTime.of(
                payload.date.value.year,
                payload.date.value.month,
                payload.date.value.dayOfMonth,
                time.hour,
                time.minute,
                time.second
            ),
            title = payload.title,
            navigationUrl = alarmDeepLink,
            id = payload.id,
            source = TaskyNotifierConfig.Source.Reminder
        )

        if (payload.completed) {
            alarmScheduler.cancel(alarm)
        } else {
            alarmScheduler.schedule(alarm)
        }
    }
}