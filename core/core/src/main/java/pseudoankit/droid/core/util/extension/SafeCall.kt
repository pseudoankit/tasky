package pseudoankit.droid.core.util.extension

import pseudoankit.droid.core.R
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.TextResource
import java.net.SocketTimeoutException

/**
 * helper function to execute a code block and handle exception
 * @param[block] execute your code
 * @param[onError] executed when any exception occurs with [TextResource] as error message
 * @return[T] type of result to be executed
 */
inline fun <T> safeCall(block: () -> T, onError: (TextResource) -> T): T = try {
    block()
} catch (exception: Exception) {
    val error = when {
        exception is SocketTimeoutException -> TextResource.WithResId(R.string.error_no_internet)
        exception.message.isNullOrBlank().not() ->
            TextResource.WithText(exception.message.orEmpty())
        else -> TextResource.WithResId(R.string.something_went_wrong)
    }
    onError(error)
}

/**
 * helper function to execute a code block and handle exception
 * @param[block] execute your code
 * @return[TextResource<T>]
 */
inline fun <T> safeCall(block: () -> TaskyResult<T>): TaskyResult<T> = safeCall(
    block = block,
    onError = {
        TaskyResult.Error(it)
    }
)