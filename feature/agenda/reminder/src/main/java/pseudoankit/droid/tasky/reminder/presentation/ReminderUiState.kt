package pseudoankit.droid.tasky.reminder.presentation

internal interface ReminderUiState {

    data class State(
        val reminderText: String = ""
    )

    sealed interface SideEffect {
        object OnNavigateUp : SideEffect
        object ShowDatePicker : SideEffect
    }
}