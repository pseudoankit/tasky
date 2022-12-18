package pseudoankit.droid.authentication.presentation.login

import pseudoankit.droid.authentication.domain.LoginUseCase
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.coreui.viewmodel.BaseViewModel

internal class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginUiState.State, LoginUiState.SideEffect, Nothing>(LoginUiState.State()) {

    fun onEmailValueChanged(value: String) = setState { copy(email = value) }

    fun onPasswordValueChanged(value: String) = setState { copy(password = value) }

    fun onLogin() {
        setState { copy(isButtonLoading = true) }
        intent {
            when (val result = loginUseCase(email = state.email, password = state.password)) {
                is TaskyResult.Error -> onLoginError(result.error)
                is TaskyResult.Success -> onLoginSuccess()
            }
        }
    }

    private fun onLoginError(error: TextResource) {
        setState { copy(isButtonLoading = false) }
    }

    private fun onLoginSuccess() {
        setState { copy(isButtonLoading = false) }
        postSideEffect { LoginUiState.SideEffect.NavigateToHomeScreen }
    }

    fun onNavigateUp() = postSideEffect { LoginUiState.SideEffect.NavigateBack }

    fun onSignup() = postSideEffect { LoginUiState.SideEffect.NavigateToRegistrationScreen }
}