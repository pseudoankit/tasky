package pseudoankit.droid.agendamanger.domain.model

import android.os.Parcelable
import androidx.compose.runtime.Stable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.model.TaskyTime

@Stable
sealed interface AgendaItem {

    val title: String
    val date: TaskyDate
    val id: Long

    @Parcelize
    @Stable
    data class Reminder(
        override val title: String = "",
        override val date: TaskyDate = TaskyDate.Today,
        val time: Time = Time.AllDay,
        val repeatInterval: RepeatInterval = RepeatInterval.DoNotRepeat,
        val completed: Boolean = false,
        override val id: Long = 0
    ) : AgendaItem, Parcelable {
        enum class RepeatInterval { DoNotRepeat, Daily, Weekly, Monthly, Yearly, Custom }

        @Parcelize
        sealed class Time : Parcelable {
            data class Time(val value: TaskyTime = TaskyTime.Now) : Reminder.Time()
            object AllDay : Reminder.Time()

            @IgnoredOnParcel
            val seconds
                get() = when (this) {
                    AllDay -> Int.MAX_VALUE
                    is Time -> value.value.second
                }
        }
    }

    data class Task(
        override val id: Long = 0,
        override val title: String = "",
        override val date: TaskyDate = TaskyDate.Today,
    ) : AgendaItem

    data class Event(
        override val id: Long = 0,
        override val title: String = "",
        override val date: TaskyDate = TaskyDate.Today,
    ) : AgendaItem

    val mapToAgendaTypes
        get() = when (this) {
            is Event -> AgendaTypes.Event(AgendaTypes.Action.Edit(id))
            is Reminder -> AgendaTypes.Reminder(AgendaTypes.Action.Edit(id))
            is Task -> AgendaTypes.Task(AgendaTypes.Action.Edit(id))
        }
}
