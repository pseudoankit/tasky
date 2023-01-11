package pseudoankit.droid.tasky.home.domain.usecase

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import pseudoankit.droid.agendamanger.domain.usecase.reminder.SaveReminderUseCase

internal class ToggleAgendaItemCompletionUseCase(
    private val reminderRepository: ReminderRepository,
    private val saveReminderUseCase: SaveReminderUseCase
) {

    suspend operator fun invoke(agenda: AgendaItem) {
        when (agenda) {
            is AgendaItem.Event -> TODO()
            is AgendaItem.Reminder -> saveReminderUseCase(
                payload = agenda.copy(completed = agenda.completed.not()),
                alarmDeepLink = "TODO"
            )
            is AgendaItem.Task -> TODO()
        }
    }
}