package pseudoankit.droid.authentication.presentation.login

internal data class LoginState(
    val email: String = "",
    val password: String = ""
)

internal sealed interface LoginSideEffect {
    object NavigateToRegistrationScreen : LoginSideEffect
    object NavigateToHomeScreen : LoginSideEffect
}
