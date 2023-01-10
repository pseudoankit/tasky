package pseudoankit.droid.core.model

import android.os.Parcelable
import androidx.compose.runtime.Stable
import kotlinx.parcelize.Parcelize
import java.time.LocalTime

@Parcelize
@Stable
@JvmInline
value class TaskyTime(val value: LocalTime) : Parcelable {

    companion object {
        val Now = TaskyTime(LocalTime.now())
    }
}