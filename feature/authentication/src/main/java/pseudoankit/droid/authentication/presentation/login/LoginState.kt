package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.core.util.Validator
import pseudoankit.droid.coreui.components.button.UnifyButton.toUnifyButtonState

// todo remove def values later on
internal data class LoginState(
    val email: String = "lostankit7@gmail.com",
    val password: String = "qwerty",
    val isButtonLoading: Boolean = false
) {
    val buttonState = Validator.validate(email, password).toUnifyButtonState(isButtonLoading)
}

internal sealed interface LoginSideEffect {
    object NavigateBack : LoginSideEffect
    object NavigateToRegistrationScreen : LoginSideEffect
    object NavigateToHomeScreen : LoginSideEffect
}
