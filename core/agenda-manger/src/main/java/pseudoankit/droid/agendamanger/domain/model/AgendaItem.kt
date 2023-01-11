package pseudoankit.droid.agendamanger.domain.model

import android.os.Parcelable
import androidx.compose.runtime.Stable
import kotlinx.parcelize.Parcelize
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.model.TaskyTime

@Stable
sealed interface AgendaItem {

    @Parcelize
    @Stable
    data class Reminder(
        val title: String = "",
        val date: TaskyDate = TaskyDate.Today,
        val time: Time = Time.AllDay,
        val repeatInterval: RepeatInterval = RepeatInterval.DoNotRepeat,
        val completed: Boolean = false,
        val id: Long = 0
    ) : AgendaItem, Parcelable {
        enum class RepeatInterval { DoNotRepeat, Daily, Weekly, Monthly, Yearly, Custom }

        @Parcelize
        sealed class Time : Parcelable {
            data class Time(val value: TaskyTime = TaskyTime.Now) : Reminder.Time()
            object AllDay : Reminder.Time()
        }
    }

    data class Task(
        val id: Long = 0
    ) : AgendaItem

    data class Event(
        val id: Long = 0
    ) : AgendaItem
}