package pseudoankit.droid.core.logger

import android.util.Log

object TaskyLogger {

    const val TAG = "TASKY LOGS"

    fun info(vararg value: String) {
        Log.i(TAG, value.joinToString(", "))
    }


}
