package pseudoankit.droid.tasky.home.presentation.taskyitems

import pseudoankit.droid.coreui.viewmodel.BaseViewModel
import pseudoankit.droid.tasky.home.domain.model.AgendaType

internal class AgendaItemsViewModel :
    BaseViewModel<AgendaItemsUiState.State, AgendaItemsUiState.SideEffect, Nothing>(
        AgendaItemsUiState.State()
    ) {

    fun onNavigateUp() = postSideEffect {
        AgendaItemsUiState.SideEffect.NavigateUp
    }

    fun onAgendaSelected(type: AgendaType) = postSideEffect {
        AgendaItemsUiState.SideEffect.NavigateToAgenda(type)
    }
}