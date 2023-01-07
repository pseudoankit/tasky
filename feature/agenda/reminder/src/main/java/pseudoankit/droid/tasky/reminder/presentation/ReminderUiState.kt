package pseudoankit.droid.tasky.reminder.presentation

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.model.TaskyTime
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.core.util.extension.parseToString
import pseudoankit.droid.tasky.reminder.presentation.mapper.RepeatIntervalUiMapper
import pseudoankit.droid.tasky.reminder.presentation.mapper.RepeatIntervalUiMapper.label
import pseudoankit.droid.tasky.reminder.presentation.mapper.RepeatIntervalUiMapper.selectedLabel

internal interface ReminderUiState {

    @Stable
    data class State(
        val reminderText: String = "",
        val remindAllDay: Boolean = false,
        val selectedDate: TaskyDate = TaskyDate.Today,
        val repeatIntervalItems: ImmutableList<RepeatIntervalConfig> = RepeatIntervalUiMapper.initialDialogItems,
        private val _selectedTime: TaskyTime = TaskyTime.Now,
    ) {
        val selectedTime get() = if (remindAllDay) null else _selectedTime
        val displayTime get() = selectedTime.parseToString()
        val displayDate get() = selectedDate.parseToString("eee, dd MMM yyyy").orEmpty()
        val selectedRepeatIntervalLabel get() = repeatIntervalItems.selectedLabel

        data class RepeatIntervalConfig(
            val item: AgendaItem.Reminder.RepeatInterval,
            val isSelected: Boolean = false
        ) {
            val label = item.label
        }
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