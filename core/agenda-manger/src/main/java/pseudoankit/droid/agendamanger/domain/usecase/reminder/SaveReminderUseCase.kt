package pseudoankit.droid.agendamanger.domain.usecase.reminder

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepositoryInternal
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.extension.safeCall

class SaveReminderUseCase : KoinComponent {

    private val repository: ReminderRepositoryInternal by inject()
    private val triggerAlarmUseCase: TriggerAlarmUseCase by inject()

    // TODO: wait for entry to save in db then schedule alarm
    suspend operator fun invoke(
        payload: AgendaItem.Reminder,
        alarmDeepLink: String
    ): TaskyResult<Unit> = safeCall(
        block = {
            coroutineScope {
                launch {
                    triggerAlarmUseCase(
                        payload,
                        alarmDeepLink
                    )
                }
                launch {
                    repository.save(payload)
                }
            }
            TaskyResult.Success(Unit)
        },
        onError = {
            TaskyResult.Error(it)
        }
    )
}