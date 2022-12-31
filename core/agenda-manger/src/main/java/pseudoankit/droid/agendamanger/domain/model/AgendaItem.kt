package pseudoankit.droid.agendamanger.domain.model

import androidx.compose.runtime.Stable
import java.time.LocalDate
import java.time.LocalTime

@Stable
sealed class AgendaItem(
    open val date: LocalDate,
    open val time: LocalTime,
    open val title: String,
    open val completed: Boolean,
) {

    @Stable
    data class Reminder(
        override val title: String = "",
        val remindAllDay: Boolean = true,
        override val date: LocalDate = LocalDate.now(),
        override val time: LocalTime = LocalTime.now(),
        val repeatInterval: RepeatInterval = RepeatInterval.DoNotRepeat,
        override val completed: Boolean = false,
        val id: Int = 0
    ) : AgendaItem(date, time, title, completed) {
        enum class RepeatInterval { DoNotRepeat, Daily, Weekly, Monthly, Yearly, Custom }
    }

    class Task : AgendaItem(LocalDate.now(), LocalTime.now(), "", false)

    class Event : AgendaItem(LocalDate.now(), LocalTime.now(), "", false)
}