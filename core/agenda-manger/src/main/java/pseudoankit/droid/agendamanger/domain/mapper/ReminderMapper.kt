package pseudoankit.droid.agendamanger.domain.mapper

import pseudoankit.droid.agendamanger.data.local.entity.ReminderEntity
import pseudoankit.droid.agendamanger.domain.model.AgendaItem

internal object ReminderMapper {

    val AgendaItem.Reminder.mapToEntity
        get() = ReminderEntity(
            title = title,
            remindAllDay = remindAllDay,
            date = date,
            time = time,
            repeatInterval = repeatInterval,
            id = id
        )

    val ReminderEntity.mapToDomain
        get() = AgendaItem.Reminder(
            title = title,
            remindAllDay = remindAllDay,
            date = date,
            time = time,
            repeatInterval = repeatInterval,
            id = id
        )
}