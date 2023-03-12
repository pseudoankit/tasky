package pseudoankit.droid.tasky.home.presentation.home

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.core.model.TaskyDate
import pseudoankit.droid.core.util.datetime.DateUtils
import pseudoankit.droid.core.util.extension.parseToString

internal interface HomeUiState {

    sealed interface SideEffect {
        object ShowDatePicker : SideEffect
        data class HighlightCurrentSelectedDate(val position: Int) : SideEffect
        object ShowAgendaItems : SideEffect
        data class NavigateToAgendaScreen(val agendaTypes: AgendaTypes) : SideEffect
        object ShowProfileIcon: SideEffect
    }

    data class State(
        val selectedDate: TaskyDate = TaskyDate.Today,
        val savedAgendaItems: ImmutableList<AgendaItem> = persistentListOf()
    ) {
        val selectedMonthDateRange: ImmutableList<TaskyDate> =
            DateUtils.getDateRangeForMonth(selectedDate)

        val displayHeaderDate get() = selectedDate.parseToString("MMM yyyy").orEmpty()
    }
}
