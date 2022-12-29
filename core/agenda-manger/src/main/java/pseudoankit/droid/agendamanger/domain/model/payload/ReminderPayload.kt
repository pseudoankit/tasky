package pseudoankit.droid.agendamanger.domain.model.payload

import pseudoankit.droid.agendamanger.domain.model.RepeatInterval
import java.time.LocalDate
import java.time.LocalTime

data class ReminderPayload(
    val reminderText: String,
    val remindAllDay: Boolean,
    val selectedDate: LocalDate,
    val selectedTime: LocalTime?,
    val repeatInterval: RepeatInterval
)
