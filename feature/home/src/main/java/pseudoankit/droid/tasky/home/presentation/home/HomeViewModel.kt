package pseudoankit.droid.tasky.home.presentation.home

import pseudoankit.droid.core.util.datetime.model.TaskyDate
import pseudoankit.droid.coreui.viewmodel.BaseViewModel
import java.time.LocalDate

internal class HomeViewModel :
    BaseViewModel<HomeUiState.State, HomeUiState.SideEffect, Nothing>(HomeUiState.State()) {

    fun onShowAgendaItems() = postSideEffect {
        HomeUiState.SideEffect.ShowAgendaItems
    }

    fun onDaySelected(date: TaskyDate) = setState {
        copy(selectedDate = date)
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