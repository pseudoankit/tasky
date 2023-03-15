package pseudoankit.droid.authentication.presentation.registration

interface RegistrationUiState {
    data class State(
        val email: String = "",
        val password: String = "",
        val name: String = ""
    )

    sealed interface SideEffect {
        object NavigateBack : SideEffect
    }

    sealed interface Event {
        data class OnNameChanged(val value: String) : Event
        data class OnEmailChanged(val value: String) : Event
        data class OnPasswordChanged(val value: String) : Event
        object OnNavigateBack : Event
    }
}