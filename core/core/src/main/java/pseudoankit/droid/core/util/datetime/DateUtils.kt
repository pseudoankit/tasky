package pseudoankit.droid.core.util.datetime

import java.time.LocalDate
import java.time.Month

object DateUtils {
    private val dayRangeOfMonth = mutableMapOf<Month, List<LocalDate>>()

    val today get() = LocalDate.now()

    /**
     * @return[List<LocalDate>] list of days which falls in the same month passed in the param
     * @param[date] date for which range needed
     */
    fun getDayRangeForDate(date: LocalDate): List<LocalDate> {
        return dayRangeOfMonth.getOrPut(date.month) {
            (1..date.lengthOfMonth()).map {
                LocalDate.of(date.year, date.month, it)
            }
        }.map {
            // returns the same date object if year is same to the date passed by client
            // else mapping the day range to update the year
            if (it.year == date.year) {
                return@map it
            }
            LocalDate.of(date.year, it.month, it.dayOfMonth)
        }
    }
}