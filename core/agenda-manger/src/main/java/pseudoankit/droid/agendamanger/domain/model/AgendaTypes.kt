package pseudoankit.droid.agendamanger.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed interface AgendaTypes {
    data class Reminder(val action: Action) : AgendaTypes
    data class Task(val action: Action) : AgendaTypes
    data class Event(val action: Action) : AgendaTypes

    @Parcelize
    sealed class Action : Parcelable {
        data class Edit(val id: Int) : Action()
        object Create : Action()
    }
}