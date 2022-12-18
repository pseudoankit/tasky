package pseudoankit.droid.tasky.home.presentation

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.core.util.datetime.DateUtils
import pseudoankit.droid.coreui.model.TaskyDate

internal interface HomeUiState {

    sealed interface SideEffect {
        object ShowDatePickerDialog : SideEffect
    }

    @Immutable
    data class State(
        val selectedDate: TaskyDate = DateUtils.today
    ) {
        val selectedMonthDateRange: ImmutableList<TaskyDate> =
            DateUtils.getDateRangeForMonth(selectedDate)
    }
}