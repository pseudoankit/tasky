package pseudoankit.droid.authentication.presentation.registration

interface RegistrationUiState {
    data class State(
        val email: String = ""
    )

    sealed interface SideEffect {
        object NavigateBack : SideEffect
    }
}