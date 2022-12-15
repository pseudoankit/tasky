package pseudoankit.droid.core.util.extension

import pseudoankit.droid.core.R
import pseudoankit.droid.core.util.TextResource
import java.net.SocketTimeoutException

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