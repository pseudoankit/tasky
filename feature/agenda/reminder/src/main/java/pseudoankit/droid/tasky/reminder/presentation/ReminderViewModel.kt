package pseudoankit.droid.tasky.reminder.presentation

import pseudoankit.droid.core.util.datetime.model.TaskyTime
import pseudoankit.droid.coreui.viewmodel.BaseViewModel
import java.time.LocalDate
import java.time.LocalTime

internal class ReminderViewModel :
    BaseViewModel<ReminderUiState.State, ReminderUiState.SideEffect, Nothing>(ReminderUiState.State()) {

    fun onTextFieldValueChanged(value: String) = setState { copy(reminderText = value) }
    fun onRemindAllDayToggled() = setState { copy(remindAllDay = remindAllDay.not()) }
    fun onDateValueChanged(date: LocalDate) = setState {
        copy(selectedDate = selectedDate.copy(date))
    }

    fun onTimeValueChanged(time: LocalTime) = setState { copy(_selectedTime = TaskyTime(time)) }


    fun onNavigateUp() = postSideEffect { ReminderUiState.SideEffect.OnNavigateUp }
    fun onTimeClicked() = postSideEffect { ReminderUiState.SideEffect.ShowTimePicker }
    fun onDateClicked() = postSideEffect { ReminderUiState.SideEffect.ShowDatePicker }


    fun onSave() {}
}