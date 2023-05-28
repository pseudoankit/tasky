package pseudoankit.droid.agendamanger.domain.usecase.reminder

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.AgendaRepository
import pseudoankit.droid.core.model.TaskyDate

class GetSavedAgendaItemsUseCase(
    private val agendaRepository: AgendaRepository
) {

    operator fun invoke(selectedDate: TaskyDate): Flow<ImmutableList<AgendaItem>> {
        return agendaRepository.getAllSavedItemFlow(selectedDate.value)
            .map { it.toImmutableList() }
    }
}