package pseudoankit.droid.authentication.presentation.login

data class LoginState(
    val email: String = "",
    val password: String = ""
)

sealed interface LoginSideEffect {
    object NavigateToRegistrationScreen : LoginSideEffect
    object NavigateToHomeScreen : LoginSideEffect
}