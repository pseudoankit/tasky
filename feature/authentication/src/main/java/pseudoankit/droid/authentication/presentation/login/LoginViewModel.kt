package pseudoankit.droid.authentication.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import pseudoankit.droid.authentication.domain.LoginUserUseCase
import pseudoankit.droid.core.dispatcher.DispatcherProvider
import pseudoankit.droid.core.util.validator.Validator
import pseudoankit.droid.coreui.util.extension.launch
import pseudoankit.droid.coreui.util.extension.postSideEffect
import pseudoankit.droid.coreui.util.extension.setState

internal class LoginViewModel(
    private val loginUserUseCase: LoginUserUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel(),
    ContainerHost<LoginUiState.State, LoginUiState.SideEffect> {

    override val container: Container<LoginUiState.State, LoginUiState.SideEffect> =
        viewModelScope.container(LoginUiState.State())

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

    fun onLogin() = launch(dispatcherProvider.io) {
        setState { copy(isLoginInProgress = true) }

        when (val result = loginUserUseCase(state)) {
            is LoginUserUseCase.Result.EmailError -> setState {
                copy(emailConfig = emailConfig.copy(errorMessage = result.message))
            }
            is LoginUserUseCase.Result.PasswordError -> setState {
                copy(passwordConfig = passwordConfig.copy(errorMessage = result.message))
            }
            is LoginUserUseCase.Result.Error -> TODO()
            LoginUserUseCase.Result.Success -> postSideEffect {
                LoginUiState.SideEffect.NavigateToHomeScreen
            }
        }

        setState { copy(isLoginInProgress = false) }
    }

    fun onSignup() = postSideEffect { LoginUiState.SideEffect.NavigateToRegistrationScreen }
}