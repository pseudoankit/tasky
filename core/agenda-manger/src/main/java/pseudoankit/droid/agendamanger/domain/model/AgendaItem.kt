package pseudoankit.droid.agendamanger.domain.model

import androidx.compose.runtime.Stable
import java.time.LocalDate
import java.time.LocalTime

@Stable
sealed class AgendaItem(
    open val date: LocalDate? = null,
    open val time: LocalTime? = null,
    open val title: String? = null,
) {

    @Stable
    data class Reminder(
        override val title: String? = null,
        val remindAllDay: Boolean? = null,
        override val date: LocalDate? = null,
        override val time: LocalTime? = null,
        val repeatInterval: RepeatInterval? = null,
        val id: Int = 0
    ) : AgendaItem(date, time, title) {
        enum class RepeatInterval { DoNotRepeat, Daily, Weekly, Monthly, Yearly, Custom }
    }

    class Task : AgendaItem()

    class Event : AgendaItem()
}