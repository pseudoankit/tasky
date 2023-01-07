package pseudoankit.droid.core.model

import androidx.compose.runtime.Stable
import java.time.LocalTime

@Stable
data class TaskyTime(val value: LocalTime) {

    companion object {
        val Now = TaskyTime(LocalTime.now())
    }
}