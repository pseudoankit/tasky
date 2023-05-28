package pseudoankit.droid.agendamanger.domain.mapper

import pseudoankit.droid.agendamanger.data.local.entity.ReminderEntity
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.model.TaskyTime
import pseudoankit.droid.core.util.extension.orFalse
import pseudoankit.droid.core.util.extension.orNow
import pseudoankit.droid.core.util.extension.orToday

internal object ReminderMapper {

    val AgendaItem.Reminder.mapToEntity
        get() = ReminderEntity(
            title = title,
            remindAllDay = time == AgendaItem.Reminder.Time.AllDay,
            date = date.value,
            time = when (time) {
                AgendaItem.Reminder.Time.AllDay -> null
                is AgendaItem.Reminder.Time.Time -> time.value.value
            },
            repeatInterval = repeatInterval,
            id = id,
            completed = completed
        )

    val ReminderEntity.mapToDomain
        get() = AgendaItem.Reminder(
            title = title.orEmpty(),
            date = TaskyDate(date.orToday),
            time = if (time == null) {
                AgendaItem.Reminder.Time.AllDay
            } else {
                AgendaItem.Reminder.Time.Time(TaskyTime(time.orNow))
            },
            repeatInterval = repeatInterval ?: AgendaItem.Reminder.RepeatInterval.DoNotRepeat,
            id = id,
            completed = completed.orFalse
        )

    val List<AgendaItem.Reminder>.sortByAscDateTime
        get() = sortedWith { o1, o2 ->
            if (o1.date.value > o2.date.value) return@sortedWith 1
            if (o1.date.value < o2.date.value) return@sortedWith -1
            o1.time.seconds - o2.time.seconds
        }
}