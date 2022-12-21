package pseudoankit.droid.tasky.reminder.presentation

internal interface ReminderUiState {

    class State

    sealed interface SideEffect {
        object OnNavigateUp : SideEffect
        object ShowDatePicker : SideEffect
    }
}