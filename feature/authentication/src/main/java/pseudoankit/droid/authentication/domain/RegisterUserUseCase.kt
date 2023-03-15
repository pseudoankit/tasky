package pseudoankit.droid.authentication.domain

import kotlinx.coroutines.delay
import pseudoankit.droid.authentication.presentation.registration.RegistrationUiState
import pseudoankit.droid.core.dispatcher.DispatcherProvider
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.core.util.extension.safeCall
import pseudoankit.droid.core.util.validator.Validator

internal class RegisterUserUseCase(
    private val dispatcherProvider: DispatcherProvider
) {

    sealed interface Result {
        data class NameError(val message: TextResource?) : Result
        data class EmailError(val message: TextResource?) : Result
        data class PasswordError(val message: TextResource?) : Result
        data class OnError(val message: TextResource) : Result
        object Success : Result
    }

    suspend operator fun invoke(state: RegistrationUiState.State): Result {
        return dispatcherProvider.switchToIo {
            safeCall(
                block = {
                    val nameError = Validator.validateName(name = state.nameConfig.value)
                    if (nameError != null) {
                        return@switchToIo Result.NameError(nameError)
                    }

                    val emailError = Validator.validateEmail(email = state.emailConfig.value)
                    if (emailError != null) {
                        return@switchToIo Result.EmailError(emailError)
                    }

                    val passwordError =
                        Validator.validatePassword(password = state.passwordConfig.value)
                    if (passwordError != null) {
                        return@switchToIo Result.PasswordError(passwordError)
                    }

                    delay(500)

                    return@switchToIo Result.Success
                },
                onError = {
                    Result.OnError(it)
                }
            )
        }
    }
}