package pseudoankit.droid.alarm_scheduler.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime

@Parcelize
data class Alarm(
    val time: LocalDateTime,
    val title: String,
    val navigationUrl: String,
    val uniqueId: Int
) : Parcelable
