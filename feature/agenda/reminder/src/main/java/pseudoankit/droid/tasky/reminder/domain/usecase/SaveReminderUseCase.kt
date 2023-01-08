package pseudoankit.droid.tasky.reminder.domain.usecase

import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import pseudoankit.droid.core.util.TaskyResult
import pseudoankit.droid.core.util.extension.safeCall
import pseudoankit.droid.tasky.reminder.presentation.ReminderUiState
import pseudoankit.droid.tasky.reminder.presentation.mapper.ReminderMapper.mapToReminderObj

internal class SaveReminderUseCase(
    private val repository: ReminderRepository
) {

    suspend operator fun invoke(state: ReminderUiState.State): TaskyResult<Unit> = safeCall(
        block = {
            val payload = state.mapToReminderObj
            repository.save(payload)
            TaskyResult.Success(Unit)
        },
        onError = {
            TaskyResult.Error(it)
        }
    )
}