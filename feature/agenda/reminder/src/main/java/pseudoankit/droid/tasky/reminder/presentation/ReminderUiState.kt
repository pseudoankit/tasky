package pseudoankit.droid.tasky.reminder.presentation

internal interface ReminderUiState {

    data class State(
        val reminderText: String = "",
        val allDayReminderEnabled: Boolean = false,
        val selectedDate: String = "Sat, 24 Dec, 2022"
    )

    sealed interface SideEffect {
        object OnNavigateUp : SideEffect
        object ShowDatePicker : SideEffect
    }
}