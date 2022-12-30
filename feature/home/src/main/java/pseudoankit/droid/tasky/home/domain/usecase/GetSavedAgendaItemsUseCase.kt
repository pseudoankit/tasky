package pseudoankit.droid.tasky.home.domain.usecase

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.core.util.datetime.model.TaskyDate

internal class GetSavedAgendaItemsUseCase {

    suspend operator fun invoke(selectedDate: TaskyDate): List<AgendaItem> {
        return listOf(

        )
    }
}