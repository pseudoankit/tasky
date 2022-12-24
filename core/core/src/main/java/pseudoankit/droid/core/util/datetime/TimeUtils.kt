package pseudoankit.droid.core.util.datetime

import pseudoankit.droid.core.util.datetime.model.TaskyTime

object TimeUtils {

    fun TaskyTime?.displayTime(): String? = this?.run {
        "10:00 am"
    }
}