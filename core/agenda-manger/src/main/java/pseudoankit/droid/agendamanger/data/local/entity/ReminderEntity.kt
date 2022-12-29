package pseudoankit.droid.agendamanger.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import pseudoankit.droid.agendamanger.domain.model.RepeatInterval
import java.time.LocalDate
import java.time.LocalTime

@Entity
data class ReminderEntity(
    val reminderText: String,
    val remindAllDay: Boolean,
    val selectedDate: LocalDate,
    val selectedTime: LocalTime?,
    val repeatInterval: RepeatInterval,

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
)