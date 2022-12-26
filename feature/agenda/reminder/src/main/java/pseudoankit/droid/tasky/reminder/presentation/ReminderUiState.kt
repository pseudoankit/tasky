package pseudoankit.droid.tasky.reminder.presentation

import androidx.compose.runtime.Stable
import pseudoankit.droid.core.util.datetime.DateUtils.toString
import pseudoankit.droid.core.util.datetime.TimeUtils.toString
import pseudoankit.droid.core.util.datetime.model.TaskyDate
import pseudoankit.droid.core.util.datetime.model.TaskyTime

internal interface ReminderUiState {

    @Stable
    data class State(
        val reminderText: String = "",
        val remindAllDay: Boolean = false,
        val selectedDate: TaskyDate = TaskyDate.Today,
        private val _selectedTime: TaskyTime = TaskyTime.Now
    ) {
        val selectedTime get() = if (remindAllDay) null else _selectedTime
        val displayTime get() = selectedTime.toString()
        val displayDate get() = selectedDate.toString("eee, dd MMM yyyy").orEmpty()
    }

    sealed interface SideEffect {
        object OnNavigateUp : SideEffect
        object ShowDatePicker : SideEffect
        object ShowTimePicker : SideEffect
    }
}