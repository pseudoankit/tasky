package pseudoankit.droid.tasky.home.presentation.taskyitems

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

internal interface AgendaItemsUiState {

    data class State(
        val items: ImmutableList<AgendaTypes> = persistentListOf(
            AgendaTypes.Reminder(AgendaTypes.Action.Create),
            AgendaTypes.Task(AgendaTypes.Action.Create),
            AgendaTypes.Event(AgendaTypes.Action.Create),
        )
    )

    sealed interface SideEffect {
        object NavigateUp : SideEffect
        data class NavigateToAgenda(val type: AgendaTypes) : SideEffect
    }
}