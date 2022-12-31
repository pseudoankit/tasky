package pseudoankit.droid.agendamanger.domain.mapper

import pseudoankit.droid.agendamanger.data.local.entity.ReminderEntity
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.extension.orFalse
import pseudoankit.droid.core.util.extension.orNow
import pseudoankit.droid.core.util.extension.orToday

internal object ReminderMapper {

    val AgendaItem.Reminder.mapToEntity
        get() = ReminderEntity(
            title = title,
            remindAllDay = remindAllDay,
            date = date,
            time = time,
            repeatInterval = repeatInterval,
            id = id,
            completed = completed
        )

    val ReminderEntity.mapToDomain
        get() = AgendaItem.Reminder(
            title = title.orEmpty(),
            remindAllDay = remindAllDay.orFalse,
            date = date.orToday,
            time = time.orNow,
            repeatInterval = repeatInterval ?: AgendaItem.Reminder.RepeatInterval.DoNotRepeat,
            id = id,
            completed = completed.orFalse
        )
}