package pseudoankit.droid.core.model

import androidx.compose.runtime.Stable
import java.time.LocalDate

// TODO
@Stable
data class TaskyDate(val value: LocalDate, val isSelected: Boolean = false) {

    companion object {
        val Today: TaskyDate get() = TaskyDate(LocalDate.now())
    }
}