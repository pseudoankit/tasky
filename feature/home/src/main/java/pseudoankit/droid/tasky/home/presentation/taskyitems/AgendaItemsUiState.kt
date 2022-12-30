package pseudoankit.droid.tasky.home.presentation.taskyitems

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import pseudoankit.droid.agendamanger.domain.model.AgendaType

internal interface AgendaItemsUiState {

    data class State(
        val items: ImmutableList<AgendaType> = persistentListOf(
            AgendaType.Reminder,
            AgendaType.Task,
            AgendaType.Event
        )
    )

    sealed interface SideEffect {
        object NavigateUp : SideEffect
        data class NavigateToAgenda(val type: AgendaType) : SideEffect
    }
}