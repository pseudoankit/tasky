package pseudoankit.droid.authentication.presentation.login

internal data class LoginState(
    val email: String = "",
    val password: String = ""
)

internal sealed interface LoginSideEffect {
    object NavigateToRegistrationScreen : LoginSideEffect
    object NavigateToHomeScreen : LoginSideEffect
}

internal sealed interface LoginEvent {
    data class OnEmailValueChanged(val value: String) : LoginEvent
}