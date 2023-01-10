package pseudoankit.droid.core.model

import android.os.Parcelable
import androidx.compose.runtime.Stable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
@Stable
@JvmInline
value class TaskyDate(val value: LocalDate) : Parcelable {

    companion object {
        val Today: TaskyDate get() = TaskyDate(LocalDate.now())
    }
}