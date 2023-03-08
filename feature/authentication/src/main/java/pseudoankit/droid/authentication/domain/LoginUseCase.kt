package pseudoankit.droid.authentication.domain

import kotlinx.coroutines.delay
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.extension.safeCall
import pseudoankit.droid.preferencesmanager.PreferenceRepository

internal class LoginUseCase(
    private val preferenceRepository: PreferenceRepository
) {

    suspend operator fun invoke(email: String, password: String): TaskyResult<Unit> = safeCall {
        delay(500)
        preferenceRepository.setIsLoggedIn(value = true)
        TaskyResult.Success(Unit)
    }
}
