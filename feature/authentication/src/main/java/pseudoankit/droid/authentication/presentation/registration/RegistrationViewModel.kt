package pseudoankit.droid.authentication.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import pseudoankit.droid.authentication.domain.RegisterUserUseCase
import pseudoankit.droid.core.dispatcher.DispatcherProvider
import pseudoankit.droid.core.util.validator.Validator
import pseudoankit.droid.coreui.util.extension.launch
import pseudoankit.droid.coreui.util.extension.postSideEffect
import pseudoankit.droid.coreui.util.extension.setState

internal class RegistrationViewModel(
    private val registerUserUseCase: RegisterUserUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel(),
    ContainerHost<RegistrationUiState.State, RegistrationUiState.SideEffect> {

    override val container: Container<RegistrationUiState.State, RegistrationUiState.SideEffect> =
        viewModelScope.container(RegistrationUiState.State())

    fun onEvent(event: RegistrationUiState.Event) = when (event) {
        is RegistrationUiState.Event.OnEmailChanged -> setState {
            copy(
                emailConfig = emailConfig.copy(
                    value = event.value,
                    errorMessage = Validator.validateEmail(email = event.value)
                )
            )
        }
        is RegistrationUiState.Event.OnNameChanged -> setState {
            copy(
                nameConfig = nameConfig.copy(
                    value = event.value,
                    errorMessage = Validator.validateName(name = event.value)
                )
            )
        }
        is RegistrationUiState.Event.OnPasswordChanged -> setState {
            copy(
                passwordConfig = passwordConfig.copy(
                    value = event.value,
                    errorMessage = Validator.validatePassword(password = event.value)
                )
            )
        }
        RegistrationUiState.Event.OnNavigateBack -> postSideEffect {
            RegistrationUiState.SideEffect.NavigateBack
        }
        RegistrationUiState.Event.OnRegisterUser -> launch(dispatcherProvider.io) {
            setState { copy(isRegistrationInProgress = true) }
            when (val result = registerUserUseCase.invoke(state)) {
                is RegisterUserUseCase.Result.EmailError -> setState {
                    copy(emailConfig = emailConfig.copy(errorMessage = result.message))
                }
                is RegisterUserUseCase.Result.NameError -> setState {
                    copy(nameConfig = nameConfig.copy(errorMessage = result.message))
                }
                is RegisterUserUseCase.Result.PasswordError -> setState {
                    copy(passwordConfig = passwordConfig.copy(errorMessage = result.message))
                }
                is RegisterUserUseCase.Result.Error -> postSideEffect {
                    RegistrationUiState.SideEffect.ShowErrorMessage(result.message)
                }
                RegisterUserUseCase.Result.Success -> postSideEffect {
                    RegistrationUiState.SideEffect.NavigateBack
                }
            }
            setState { copy(isRegistrationInProgress = false) }
        }
    }
}
