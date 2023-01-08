package pseudoankit.droid.tasky.home.domain.usecase

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.extension.safeCall

class DeleteAgendaUseCase(
    private val reminderRepository: ReminderRepository
) {

    suspend operator fun invoke(agendaItem: AgendaItem) = safeCall {
        when (agendaItem) {
            is AgendaItem.Event -> TODO()
            is AgendaItem.Reminder -> reminderRepository.delete(agendaItem)
            is AgendaItem.Task -> TODO()
        }
        TaskyResult.Success(Unit)
    }
}