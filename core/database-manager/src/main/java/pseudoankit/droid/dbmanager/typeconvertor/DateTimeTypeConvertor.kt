package pseudoankit.droid.dbmanager.typeconvertor

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalTime

// TODO json serializer
class DateTimeTypeConvertor {

    @TypeConverter
    fun convert(date: LocalDate): String {
        return date.toString()
    }

    @TypeConverter
    fun convert(time: LocalTime): String {
        return time.toString()
    }

    @TypeConverter
    fun convertToDate(date: String): LocalDate {
        return LocalDate.now()
    }

    @TypeConverter
    fun convertToTime(time: String): LocalTime {
        return LocalTime.now()
    }
}