package pseudoankit.droid.tasky.reminder.presentation

import pseudoankit.droid.core.util.datetime.model.TaskyDate
import pseudoankit.droid.core.util.datetime.model.TaskyTime
import pseudoankit.droid.coreui.viewmodel.BaseViewModel

internal class ReminderViewModel :
    BaseViewModel<ReminderUiState.State, ReminderUiState.SideEffect, Nothing>(ReminderUiState.State()) {

    fun onTextFieldValueChanged(value: String) = setState { copy(reminderText = value) }
    fun onRemindAllDayToggled() = setState { copy(remindAllDay = remindAllDay.not()) }
    fun onDateValueChanged(date: TaskyDate) = setState { copy(selectedDate = date) }
    fun onTimeValueChanged(time: TaskyTime) = setState { copy(_selectedTime = time) }


    fun onNavigateUp() = postSideEffect { ReminderUiState.SideEffect.OnNavigateUp }
    fun onTimeClicked() = postSideEffect { ReminderUiState.SideEffect.ShowTimePicker }
    fun onDateClicked() = postSideEffect { ReminderUiState.SideEffect.ShowDatePicker }


    fun onSave() {}
}