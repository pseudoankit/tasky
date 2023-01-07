package pseudoankit.droid.core.util.datetime

import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.util.extension.mapToImmutableList
import java.time.LocalDate
import java.time.Month

object DateUtils {
    private val dateRangeOfMonthCache = mutableMapOf<Month, List<LocalDate>>()

    /**
     * @return[List<LocalDate>] list of days which falls in the same month passed in the param
     * @param[date] date for which range needed
     */
    fun getDateRangeForMonth(date: TaskyDate): ImmutableList<TaskyDate> {
        return dateRangeOfMonthCache.getOrPut(date.value.month) {
            (1..date.value.lengthOfMonth()).map {
                LocalDate.of(date.value.year, date.value.month, it)
            }
        }.mapToImmutableList {
            // wrapping with TaskyDate and mapping the year same passed by client
            TaskyDate(
                value = LocalDate.of(date.value.year, it.month, it.dayOfMonth),
                isSelected = date.value.dayOfMonth == it.dayOfMonth
            )
        }
    }
}