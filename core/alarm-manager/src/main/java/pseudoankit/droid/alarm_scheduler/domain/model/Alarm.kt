package pseudoankit.droid.alarm_scheduler.domain.model

import android.os.Build
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.*

@Parcelize
data class Alarm(
    val localDateTime: LocalDateTime,
    val title: String,
    val navigationUrl: String,
    val id: Long,
) : Parcelable {

    val timeInMillis get() = localDateTime.atZone(ZoneId.systemDefault()).toEpochSecond().times(1000)
}
