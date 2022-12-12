package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.core.util.Validator
import pseudoankit.droid.core.viewmodel.BaseViewModel
import pseudoankit.droid.coreui.components.button.toTaskyButtonState

internal class LoginViewModel : BaseViewModel<LoginState, LoginSideEffect>(LoginState()) {

    fun onEmailValueChanged(value: String) = setState {
        copy(email = value, buttonState = Validator.validate(value, password).toTaskyButtonState)
    }

    fun onPasswordValueChanged(value: String) = setState {
        copy(password = value, buttonState = Validator.validate(email, value).toTaskyButtonState)
    }

    fun onLogin() {

    }

    fun onNavigateUp() = postSideEffect {
        LoginSideEffect.NavigateBack
    }

    fun onSignup() = postSideEffect {
        LoginSideEffect.NavigateToRegistrationScreen
    }
}