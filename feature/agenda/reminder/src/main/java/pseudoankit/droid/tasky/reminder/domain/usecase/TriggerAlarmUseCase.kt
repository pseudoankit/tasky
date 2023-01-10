package pseudoankit.droid.tasky.reminder.domain.usecase

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.alarm_scheduler.domain.AlarmScheduler
import pseudoankit.droid.alarm_scheduler.domain.model.Alarm
import java.time.LocalDateTime
import java.time.LocalTime

internal class TriggerAlarmUseCase(
    private val alarmScheduler: AlarmScheduler
) {

    operator fun invoke(payload: AgendaItem.Reminder) {
        val time = when (payload.time) {
            AgendaItem.Reminder.Time.AllDay -> LocalTime.NOON
            is AgendaItem.Reminder.Time.Time -> (payload.time as AgendaItem.Reminder.Time.Time).value.value
        }

        // TODO: build route and pass
        val alarm = Alarm(
            time = LocalDateTime.of(
                payload.date.value.year,
                payload.date.value.month,
                payload.date.value.dayOfMonth,
                time.hour,
                time.minute,
                time.second
            ),
            title = payload.title,
            navigationUrl = ""
        )

        alarmScheduler.schedule(alarm)
    }
}