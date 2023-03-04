package pseudoankit.droid.core.logger

import android.util.Log

object TaskyLogger {

    private const val TAG = "TASKY LOGS"

    fun info(vararg value: String) {
        Log.i("$TAG Info", value.joinToString(", "))
    }

    fun error(vararg value: String) {
        Log.e("$TAG Error", value.joinToString(", "))
    }
}
