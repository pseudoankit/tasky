package pseudoankit.droid.tasky.home.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toImmutableList
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import org.orbitmvi.orbit.syntax.simple.intent
import pseudoankit.droid.core.util.datetime.model.TaskyDate
import pseudoankit.droid.coreui.util.extension.postSideEffect
import pseudoankit.droid.coreui.util.extension.setState
import pseudoankit.droid.coreui.util.extension.state
import pseudoankit.droid.tasky.home.domain.usecase.GetSavedAgendaItemsUseCase
import java.time.LocalDate

internal class HomeViewModel(
    private val getSavedAgendaItemsUseCase: GetSavedAgendaItemsUseCase
) : ViewModel(),
    ContainerHost<HomeUiState.State, HomeUiState.SideEffect> {

    override val container: Container<HomeUiState.State, HomeUiState.SideEffect> =
        viewModelScope.container(HomeUiState.State())

    fun onShowAgendaItems() = postSideEffect {
        HomeUiState.SideEffect.ShowAgendaItems
    }

    fun onDaySelected(date: TaskyDate) = intent {
        val items = getSavedAgendaItemsUseCase.invoke(state.selectedDate)
        setState {
            copy(
                selectedDate = date,
                savedAgendaItems = items.toImmutableList()
            )
        }
    }

    fun onHeaderMonthSelected() = postSideEffect {
        HomeUiState.SideEffect.ShowDatePicker
    }

    fun onDateChanged(date: LocalDate) {
        setState {
            copy(selectedDate = TaskyDate(date))
        }
        highlightCurrentSelectedDate()
    }

    fun onInit() {
        highlightCurrentSelectedDate()
    }

    private fun highlightCurrentSelectedDate() = postSideEffect {
        HomeUiState.SideEffect.HighlightCurrentSelectedDate(state.selectedDate.value.dayOfMonth - 1)
    }
}