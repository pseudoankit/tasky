package pseudoankit.droid.tasky.reminder.presentation

import androidx.compose.runtime.Stable
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.core.util.datetime.DateUtils.toString
import pseudoankit.droid.core.util.datetime.TimeUtils.toString
import pseudoankit.droid.core.util.datetime.model.TaskyDate
import pseudoankit.droid.core.util.datetime.model.TaskyTime
import pseudoankit.droid.tasky.reminder.domain.model.RepeatInterval
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
        val displayTime get() = selectedTime.toString()
        val displayDate get() = selectedDate.toString("eee, dd MMM yyyy").orEmpty()
        val selectedRepeatIntervalLabel get() = repeatIntervalItems.selectedLabel

        data class RepeatIntervalConfig(
            val item: RepeatInterval,
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
    }
}