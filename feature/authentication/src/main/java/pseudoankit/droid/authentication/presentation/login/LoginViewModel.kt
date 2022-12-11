package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.coreui.base.BaseViewModel

internal class LoginViewModel :
    BaseViewModel<LoginState, LoginSideEffect, LoginEvent>(LoginState()) {

    override fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnEmailValueChanged -> setState {
                copy(email = event.value)
            }
        }
    }
}