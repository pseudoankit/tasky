package pseudoankit.droid.core.util.datetime.model

import androidx.compose.runtime.Stable
import java.time.LocalDate

@Stable
data class TaskyDate(val value: LocalDate, val isSelected: Boolean = false) {

    companion object {
        val Today: TaskyDate get() = TaskyDate(LocalDate.now())
    }
}