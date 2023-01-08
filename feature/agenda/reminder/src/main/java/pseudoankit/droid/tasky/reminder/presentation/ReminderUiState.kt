package pseudoankit.droid.tasky.reminder.presentation

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.toImmutableList
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.model.TaskyTime
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.core.util.extension.parseToString

internal interface ReminderUiState {

    @Stable
    data class State(
        val reminderText: String = "",
        val remindAllDay: Boolean = false,
        val selectedDate: TaskyDate = TaskyDate.Today,
        val selectedRepeatInterval: AgendaItem.Reminder.RepeatInterval = AgendaItem.Reminder.RepeatInterval.DoNotRepeat,
        private val _selectedTime: TaskyTime = TaskyTime.Now,
        val editId: Int? = null
    ) {
        val selectedTime get() = if (remindAllDay) null else _selectedTime
        val displayTime get() = selectedTime.parseToString()
        val displayDate get() = selectedDate.parseToString("eee, dd MMM yyyy").orEmpty()
        val repeatIntervalItems =
            AgendaItem.Reminder.RepeatInterval.values().toList().toImmutableList()
    }

    sealed interface SideEffect {
        object NavigateUp : SideEffect
        object ShowDatePicker : SideEffect
        object ShowTimePicker : SideEffect
        object ToggleRepeatIntervalSelectionView : SideEffect
        object ShowCustomRepeatIntervalSelector : SideEffect
        object NavigateToHomeScreen : SideEffect
        data class ShowError(val message: TextResource) : SideEffect
    }
}