package pseudoankit.droid.core.logger

import android.util.Log

object TaskyLogger {

    private const val INTERNAL_TAG = "TASKY LOGS"

    fun info(vararg value: Any, tag: String = "") {
        Log.i("$INTERNAL_TAG $tag", value.joinToString(", "))
    }

    fun error(vararg value: Any, tag: String = "") {
        Log.e("$INTERNAL_TAG $tag", value.joinToString(", "))
    }
}

fun logInfo(vararg value: Any, tag: String = "") {
    TaskyLogger.info(*value, tag)
}

fun logError(vararg value: Any, tag: String = "") {
    TaskyLogger.error(*value, tag)
}
