package pseudoankit.droid.tasky.home.domain.usecase

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository

internal class ToggleAgendaItemCompletionUseCase(
    private val reminderRepository: ReminderRepository
) {

    suspend operator fun invoke(agenda: AgendaItem) {
        when (agenda) {
            is AgendaItem.Event -> TODO()
            is AgendaItem.Reminder -> reminderRepository.update(agenda.copy(completed = agenda.completed.not()))
            is AgendaItem.Task -> TODO()
        }
    }
}