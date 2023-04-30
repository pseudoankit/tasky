package pseudoankit.droid.tasky.reminder.presentation.mapper

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.model.TaskyTime
import pseudoankit.droid.core.util.datetime.TimeUtils.orNow
import pseudoankit.droid.tasky.reminder.presentation.ReminderUiState

internal object ReminderMapper {

    val ReminderUiState.State.mapToReminderObj
        get() = kotlin.run {
            AgendaItem.Reminder(
                title = reminderText,
                date = selectedDate,
                time = if (remindAllDay) {
                    AgendaItem.Reminder.Time.AllDay
                } else {
                    AgendaItem.Reminder.Time.Time(selectedTime.orNow)
                },
                repeatInterval = selectedRepeatInterval,
                id = editId ?: System.currentTimeMillis()
            )
        }

    val AgendaItem.Reminder.mapToUiState
        get() = kotlin.run {
            ReminderUiState.State(
                reminderText = title,
                selectedDate = date,
                selectedRepeatInterval = repeatInterval,
                remindAllDay = time == AgendaItem.Reminder.Time.AllDay,
                _selectedTime = when (time) {
                    AgendaItem.Reminder.Time.AllDay -> TaskyTime.Now
                    is AgendaItem.Reminder.Time.Time -> (time as? AgendaItem.Reminder.Time.Time)?.value.orNow
                },
                editId = id
            )
        }
}