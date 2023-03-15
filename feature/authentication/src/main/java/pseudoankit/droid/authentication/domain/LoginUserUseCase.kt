package pseudoankit.droid.authentication.domain

import kotlinx.coroutines.delay
import pseudoankit.droid.authentication.presentation.login.LoginUiState
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.core.util.extension.safeCall
import pseudoankit.droid.core.util.validator.Validator
import pseudoankit.droid.preferencesmanager.PreferenceRepository

internal class LoginUserUseCase(
    private val preferenceRepository: PreferenceRepository
) {

    sealed interface Result {
        data class EmailError(val message: TextResource?) : Result
        data class PasswordError(val message: TextResource?) : Result
        data class Error(val message: TextResource) : Result
        object Success : Result
    }

    suspend operator fun invoke(state: LoginUiState.State): Result {
        return safeCall(
            block = {
                val emailError = Validator.validateEmail(email = state.emailConfig.value)
                if (emailError != null) {
                    return Result.EmailError(emailError)
                }

                val passwordError =
                    Validator.validatePassword(password = state.passwordConfig.value)
                if (passwordError != null) {
                    return Result.PasswordError(passwordError)
                }

                delay(500)
                preferenceRepository.setIsLoggedIn(value = true)
                Result.Success
            },
            onError = {
                Result.Error(it)
            }
        )
    }
}
