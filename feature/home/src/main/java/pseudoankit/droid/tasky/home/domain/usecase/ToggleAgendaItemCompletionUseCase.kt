package pseudoankit.droid.tasky.home.domain.usecase

import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import pseudoankit.droid.agendamanger.domain.usecase.reminder.SaveReminderUseCase
import pseudoankit.droid.tasky.home.navigator.HomeDeepLinkProvider

internal class ToggleAgendaItemCompletionUseCase(
    private val reminderRepository: ReminderRepository,
    private val saveReminderUseCase: SaveReminderUseCase,
    private val deepLinkProvider: HomeDeepLinkProvider
) {

    suspend operator fun invoke(agenda: AgendaItem) {
        when (agenda) {
            is AgendaItem.Event -> TODO()
            is AgendaItem.Reminder -> saveReminderUseCase(
                payload = agenda.copy(completed = agenda.completed.not()),
                alarmDeepLink = deepLinkProvider.reminderScreenRoute(AgendaTypes.Action.Edit(agenda.id))
            )
            is AgendaItem.Task -> TODO()
        }
    }
}
