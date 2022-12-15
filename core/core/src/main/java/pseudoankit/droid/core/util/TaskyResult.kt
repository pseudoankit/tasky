package pseudoankit.droid.core.util

sealed interface TaskyResult<T> {
    data class Success<T>(val data: T) : TaskyResult<T>
    data class Error<T>(val error: TextResource) : TaskyResult<T>
}