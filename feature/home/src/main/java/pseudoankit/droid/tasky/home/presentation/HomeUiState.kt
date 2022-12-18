package pseudoankit.droid.tasky.home.presentation

import java.time.LocalDate

internal interface HomeUiState {

    sealed interface SideEffect {
        object NavigateUp : SideEffect
    }

    sealed interface Event {
        object OnNavigateUp : SideEffect
    }

    data class State(
        val selectedDate: LocalDate = LocalDate.now()
    )
}