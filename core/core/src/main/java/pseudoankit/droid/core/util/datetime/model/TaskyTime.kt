package pseudoankit.droid.core.util.datetime.model

import java.time.LocalTime

// TODO: immutable


data class TaskyTime(val value: LocalTime) {

    companion object {
        val Now = TaskyTime(LocalTime.now())
    }
}