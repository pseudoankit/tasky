package pseudoankit.droid.agendamanger.domain.model

import androidx.compose.runtime.Stable
import java.time.LocalDate
import java.time.LocalTime

@Stable
sealed interface AgendaItem {

    @Stable
    data class Reminder(
        val title: String? = null,
        val remindAllDay: Boolean? = null,
        val date: LocalDate? = null,
        val time: LocalTime? = null,
        val repeatInterval: RepeatInterval? = null,
        val id: Int = 0
    ) : AgendaItem {
        enum class RepeatInterval { DoNotRepeat, Daily, Weekly, Monthly, Yearly, Custom }
    }

    class Task : AgendaItem

    class Event : AgendaItem
}