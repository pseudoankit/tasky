package pseudoankit.droid.core.util.datetime

import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.core.util.extension.mapToImmutableList
import pseudoankit.droid.coreui.model.TaskyDate
import java.time.LocalDate
import java.time.Month

object DateUtils {
    private val dateRangeOfMonthCache = mutableMapOf<Month, List<LocalDate>>()

    val today: TaskyDate get() = TaskyDate(LocalDate.now())

    /**
     * @return[List<LocalDate>] list of days which falls in the same month passed in the param
     * @param[date] date for which range needed
     */
    fun getDateRangeForMonth(date: TaskyDate): ImmutableList<TaskyDate> {
        return dateRangeOfMonthCache.getOrPut(date.date.month) {
            (1..date.date.lengthOfMonth()).map {
                LocalDate.of(date.date.year, date.date.month, it)
            }
        }.mapToImmutableList {
            // wrapping with TaskyDate and mapping the year same passed by client
            TaskyDate(
                date = LocalDate.of(date.date.year, it.month, it.dayOfMonth),
                isSelected = date.date.dayOfMonth == it.dayOfMonth
            )
        }
    }
}