package pseudoankit.droid.authentication.presentation.registration

internal data class RegistrationState(
    val email: String = ""
)

internal sealed interface RegistrationSideEffect {
    object NavigateBack : RegistrationSideEffect
}