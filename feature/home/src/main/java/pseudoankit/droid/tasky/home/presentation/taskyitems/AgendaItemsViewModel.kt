package pseudoankit.droid.tasky.home.presentation.taskyitems

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.coreui.util.extension.postSideEffect

internal class AgendaItemsViewModel : ViewModel(),
    ContainerHost<AgendaItemsUiState.State, AgendaItemsUiState.SideEffect> {

    override val container: Container<AgendaItemsUiState.State, AgendaItemsUiState.SideEffect> =
        viewModelScope.container(AgendaItemsUiState.State())

    fun onNavigateUp() = postSideEffect {
        AgendaItemsUiState.SideEffect.NavigateUp
    }

    fun onAgendaSelected(type: AgendaItem) = postSideEffect {
        AgendaItemsUiState.SideEffect.NavigateToAgenda(type)
    }
}