package pseudoankit.droid.tasky.home.domain.usecase

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.extension.safeCall
import pseudoankit.droid.core.widget.UpdateAppWidgetFlow

class DeleteAgendaUseCase(
    private val reminderRepository: ReminderRepository,
    private val updateAppWidgetFlow: UpdateAppWidgetFlow
) {

    suspend operator fun invoke(agendaItem: AgendaItem) = safeCall {
        when (agendaItem) {
            is AgendaItem.Event -> TODO()
            is AgendaItem.Reminder -> reminderRepository.delete(agendaItem)
            is AgendaItem.Task -> TODO()
        }

        updateAppWidgetFlow.emit(Unit)
        TaskyResult.Success(Unit)
    }
}