package pseudoankit.droid.tasky.home.presentation

internal interface HomeUiState {

    sealed interface SideEffect {
        object NavigateUp : SideEffect
    }

    sealed interface Event {
        object OnNavigateUp : SideEffect
    }

    class State(

    )
}