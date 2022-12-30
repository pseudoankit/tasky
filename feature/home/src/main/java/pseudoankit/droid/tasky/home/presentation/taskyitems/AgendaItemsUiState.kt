package pseudoankit.droid.tasky.home.presentation.taskyitems

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import pseudoankit.droid.agendamanger.domain.model.AgendaItem

internal interface AgendaItemsUiState {

    data class State(
        val items: ImmutableList<AgendaItem> = persistentListOf(
            AgendaItem.Reminder(),
            AgendaItem.Task(),
            AgendaItem.Event()
        )
    )

    sealed interface SideEffect {
        object NavigateUp : SideEffect
        data class NavigateToAgenda(val type: AgendaItem) : SideEffect
    }
}