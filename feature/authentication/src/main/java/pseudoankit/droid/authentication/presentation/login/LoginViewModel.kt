package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.authentication.domain.LoginUseCase
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.validator.Validator
import pseudoankit.droid.coreui.viewmodel.BaseViewModel

internal class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginUiState.State, LoginUiState.SideEffect, Nothing>(LoginUiState.State()) {

    fun onEmailValueChanged(value: String) = setState {
        copy(
            emailConfig = emailConfig.copy(
                value = value,
                errorMessage = Validator.validateEmail(email = value)
            )
        )
    }

    fun onPasswordValueChanged(value: String) = setState {
        copy(
            passwordConfig = passwordConfig.copy(
                value = value,
                errorMessage = Validator.validatePassword(password = value)
            )
        )
    }

    fun onLogin() {
        setState { copy(isButtonLoading = true) }
        intent {
            val loginResult = loginUseCase(
                email = state.emailConfig.value,
                password = state.passwordConfig.value
            )
            when (loginResult) {
                is TaskyResult.Error -> setState { copy(isButtonLoading = false) }
                is TaskyResult.Success -> postSideEffect {
                    setState { copy(isButtonLoading = false) }
                    LoginUiState.SideEffect.NavigateToHomeScreen
                }
            }
        }
    }

    fun onSignup() = postSideEffect { LoginUiState.SideEffect.NavigateToRegistrationScreen }
}