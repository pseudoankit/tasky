package pseudoankit.droid.tasky.reminder.presentation

import pseudoankit.droid.coreui.viewmodel.BaseViewModel

internal class ReminderViewModel :
    BaseViewModel<ReminderUiState.State, ReminderUiState.SideEffect, Nothing>(ReminderUiState.State()) {

    fun onReminderTextFieldValueChanged(value: String) = setState { copy(reminderText = value) }

    fun onRemindAllDayToggled() = setState { copy(remindAllDay = remindAllDay.not()) }


    fun onNavigateUp() = postSideEffect { ReminderUiState.SideEffect.OnNavigateUp }

    fun onTimeSelected() = postSideEffect { ReminderUiState.SideEffect.ShowTimePicker }

    fun onDateSelected() = postSideEffect { ReminderUiState.SideEffect.ShowDatePicker }


    fun onSave() {}
}