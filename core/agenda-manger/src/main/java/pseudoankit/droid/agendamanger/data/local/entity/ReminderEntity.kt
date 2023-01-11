package pseudoankit.droid.agendamanger.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import java.time.LocalDate
import java.time.LocalTime

@Entity
data class ReminderEntity(
    val title: String?,
    val remindAllDay: Boolean?,
    val date: LocalDate?,
    val time: LocalTime?,
    val repeatInterval: AgendaItem.Reminder.RepeatInterval?,
    val completed: Boolean?,
    @PrimaryKey val id: Long
)