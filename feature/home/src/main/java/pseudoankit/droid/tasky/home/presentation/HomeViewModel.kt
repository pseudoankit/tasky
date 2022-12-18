package pseudoankit.droid.tasky.home.presentation

import pseudoankit.droid.coreui.model.TaskyDate
import pseudoankit.droid.coreui.viewmodel.BaseViewModel

internal class HomeViewModel :
    BaseViewModel<HomeUiState.State, HomeUiState.SideEffect, Nothing>(HomeUiState.State()) {

    fun onDaySelected(date: TaskyDate) = setState {
        copy(selectedDate = date)
    }

    fun onMonthSelected() = postSideEffect {
        HomeUiState.SideEffect.ShowDatePickerDialog
    }
}