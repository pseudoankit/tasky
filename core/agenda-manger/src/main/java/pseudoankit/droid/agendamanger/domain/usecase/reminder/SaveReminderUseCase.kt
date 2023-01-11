package pseudoankit.droid.agendamanger.domain.usecase.reminder

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.extension.safeCall

class SaveReminderUseCase(
    private val repository: ReminderRepository,
    private val triggerAlarmUseCase: TriggerAlarmUseCase
) {

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