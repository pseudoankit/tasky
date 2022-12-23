package pseudoankit.droid.tasky.reminder.presentation

import androidx.compose.runtime.Stable

internal interface ReminderUiState {

    @Stable
    data class State(
        val reminderText: String = "",
        val remindAllDay: Boolean = false,
        val selectedDate: String = "Sat, 24 Dec, 2022",
        private val _selectedTime: String = "03:00 am"
    ) {
        val selectedTime get() = if (remindAllDay) null else _selectedTime
    }

    sealed interface SideEffect {
        object OnNavigateUp : SideEffect
        object ShowDatePicker : SideEffect
    }
}