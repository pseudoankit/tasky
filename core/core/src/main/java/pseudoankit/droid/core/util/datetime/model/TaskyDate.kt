package pseudoankit.droid.core.util.datetime.model

import java.time.LocalDate

data class TaskyDate(val value: LocalDate, val isSelected: Boolean = false) {

    companion object {
        val Today: TaskyDate get() = TaskyDate(LocalDate.now())
    }
}