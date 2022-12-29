package pseudoankit.droid.agendamanger.domain.repository

import pseudoankit.droid.agendamanger.domain.model.payload.ReminderPayload

interface ReminderRepository {
    fun save(payload: ReminderPayload)
}