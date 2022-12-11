package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.coreui.components.button.TaskyButtonConfig

internal data class LoginState(
    val email: String = "",
    val password: String = "",
    val buttonState: TaskyButtonConfig.State = TaskyButtonConfig.State.Disabled
)

internal sealed interface LoginSideEffect {
    object NavigateBack : LoginSideEffect
    object NavigateToRegistrationScreen : LoginSideEffect
    object NavigateToHomeScreen : LoginSideEffect
}
