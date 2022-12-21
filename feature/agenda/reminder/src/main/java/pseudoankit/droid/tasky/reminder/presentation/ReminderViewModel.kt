package pseudoankit.droid.tasky.reminder.presentation

import pseudoankit.droid.coreui.viewmodel.BaseViewModel

internal class ReminderViewModel :
    BaseViewModel<ReminderUiState.State, ReminderUiState.SideEffect, Nothing>(ReminderUiState.State()) {


    fun onNavigateUp() = postSideEffect {
        ReminderUiState.SideEffect.OnNavigateUp
    }

    fun onSave() {}
}