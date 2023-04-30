package pseudoankit.droid.agendamanger.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import pseudoankit.droid.core.testtag.AgendaTestTag

sealed interface AgendaTypes {
    data class Reminder(val action: Action) : AgendaTypes
    data class Task(val action: Action) : AgendaTypes
    data class Event(val action: Action) : AgendaTypes

    @Parcelize
    sealed class Action : Parcelable {
        data class Edit(val id: Long) : Action()
        object Create : Action()
    }

    val testTag
        get() = when (this) {
            is Event -> AgendaTestTag.event
            is Reminder -> AgendaTestTag.reminder
            is Task -> AgendaTestTag.task
        }
}