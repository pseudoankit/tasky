package pseudoankit.droid.tasky.home.presentation

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.core.util.datetime.DateUtils
import pseudoankit.droid.coreui.model.TaskyDate

internal interface HomeUiState {

    sealed interface SideEffect {
        object ShowDatePickerDialog : SideEffect
        data class HighlightCurrentSelectedDate(val position: Int) : SideEffect
    }

    @Immutable
    data class State(
        val selectedDate: TaskyDate = DateUtils.today,
        val showAgendaItems: Boolean = false
    ) {
        val selectedMonthDateRange: ImmutableList<TaskyDate> =
            DateUtils.getDateRangeForMonth(selectedDate)

        /** returns month appended with year's last 2 digit */
        val displayHeaderDate get() = "${selectedDate.date.month} ${selectedDate.date.year % 100}"
    }
}