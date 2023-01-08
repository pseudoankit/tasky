package pseudoankit.droid.core.util.datetime

import pseudoankit.droid.core.model.TaskyTime
import java.time.LocalTime

object TimeUtils {
    val TaskyTime?.orNow get() = this ?: TaskyTime(LocalTime.now())
}