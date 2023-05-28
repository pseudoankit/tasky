package pseudoankit.droid.dbmanager.typeconvertor

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import pseudoankit.droid.core.util.defaultJsonSerializer
import java.time.LocalDate
import java.time.LocalTime

class DateTimeTypeConvertor {

    @kotlinx.serialization.Serializable
    private data class ParseDate(val year: Int, val month: Int, val day: Int)

    @kotlinx.serialization.Serializable
    private data class ParseTime(val hour: Int, val minute: Int)


    @TypeConverter
    fun encode(date: LocalDate): String {
        return defaultJsonSerializer.encodeToString(
            ParseDate(
                date.year,
                date.month.value,
                date.dayOfMonth
            )
        )
    }

    @TypeConverter
    fun decodeToDate(date: String): LocalDate {
        val parsed = defaultJsonSerializer.decodeFromString<ParseDate>(date)
        return LocalDate.of(parsed.year, parsed.month, parsed.day)
    }

    @TypeConverter
    fun encode(time: LocalTime): String {
        return defaultJsonSerializer.encodeToString(ParseTime(time.hour, time.minute))
    }

    @TypeConverter
    fun decodeToTime(time: String): LocalTime {
        val parse = defaultJsonSerializer.decodeFromString<ParseTime>(time)
        return LocalTime.of(parse.hour, parse.minute)
    }
}