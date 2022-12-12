package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.coreui.components.button.UnifyButton

internal data class LoginState(
    val email: String = "",
    val password: String = "",
    val buttonState: UnifyButton.State = UnifyButton.State.Disabled
)

internal sealed interface LoginSideEffect {
    object NavigateBack : LoginSideEffect
    object NavigateToRegistrationScreen : LoginSideEffect
    object NavigateToHomeScreen : LoginSideEffect
}
