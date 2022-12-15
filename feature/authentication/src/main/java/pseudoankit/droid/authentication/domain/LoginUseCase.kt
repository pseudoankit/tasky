package pseudoankit.droid.authentication.domain

import kotlinx.coroutines.delay
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.extension.safeCall

internal class LoginUseCase {

    suspend operator fun invoke(email: String, password: String): TaskyResult<Unit> = safeCall(
        block = {
            delay(1000)
            TaskyResult.Success(Unit)
        }, onError = {
            TaskyResult.Error(it)
        }
    )
}