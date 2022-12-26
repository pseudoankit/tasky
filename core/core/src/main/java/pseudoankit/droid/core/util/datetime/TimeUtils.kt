package pseudoankit.droid.core.util.datetime

import pseudoankit.droid.core.util.datetime.model.TaskyTime
import java.time.format.DateTimeFormatter

object TimeUtils {

    fun TaskyTime?.toString(pattern: String = "hh:mm a"): String? = this?.run {
        value.format(DateTimeFormatter.ofPattern(pattern))
    }
}