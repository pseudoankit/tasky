package pseudoankit.droid.core.util.extension

import pseudoankit.droid.core.util.datetime.model.TaskyDate
import pseudoankit.droid.core.util.datetime.model.TaskyTime
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

val LocalDate?.orToday: LocalDate get() = this ?: LocalDate.now()

fun TaskyDate?.parseToString(pattern: String): String? = this?.value.parseToString(pattern)

fun LocalDate?.parseToString(pattern: String): String? = this?.run {
    format(DateTimeFormatter.ofPattern(pattern))
}

/* -------------------------------------- -------------------------------------- */

val LocalTime?.orNow: LocalTime get() = this ?: LocalTime.now()

fun TaskyTime?.parseToString(pattern: String = "hh:mm a"): String? =
    this?.value.parseToString(pattern)

fun LocalTime?.parseToString(pattern: String = "hh:mm a"): String? = this?.run {
    format(DateTimeFormatter.ofPattern(pattern))
}