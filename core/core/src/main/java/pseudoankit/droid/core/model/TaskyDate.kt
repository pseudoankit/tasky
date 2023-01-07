package pseudoankit.droid.core.model

import androidx.compose.runtime.Stable
import java.time.LocalDate

// TODO delegates check
@Stable
@JvmInline
value class TaskyDate(val value: LocalDate) {

    companion object {
        val Today: TaskyDate get() = TaskyDate(LocalDate.now())
    }
}