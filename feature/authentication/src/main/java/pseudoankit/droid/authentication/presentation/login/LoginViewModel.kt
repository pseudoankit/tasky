package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.coreui.base.BaseViewModel

class LoginViewModel : BaseViewModel<LoginState, LoginSideEffect>(LoginState()) {

    fun onEmailValueChanged(value: String) = setState {
        copy(email = value)
    }
}