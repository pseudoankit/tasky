package pseudoankit.droid.alarm_scheduler.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime
import java.time.ZoneId

@Parcelize
data class Alarm(
    val time: LocalDateTime,
    val title: String,
    val navigationUrl: String,
    val id: Long,
) : Parcelable {

    val timeInMillis get() = time.atZone(ZoneId.systemDefault()).toEpochSecond().times(1000)
}
