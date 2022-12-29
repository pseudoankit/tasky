package pseudoankit.droid.agendamanger.domain.mapper

import pseudoankit.droid.agendamanger.data.local.entity.ReminderEntity
import pseudoankit.droid.agendamanger.domain.model.payload.ReminderPayload

internal object ReminderMapper {

    val ReminderPayload.mapToEntity
        get() = ReminderEntity(
            reminderText = reminderText,
            remindAllDay = remindAllDay,
            selectedDate = selectedDate,
            selectedTime = selectedTime,
            repeatInterval = repeatInterval
        )
}