package pseudoankit.droid.agendamanger.data.repository

import pseudoankit.droid.agendamanger.data.local.dao.ReminderDao
import pseudoankit.droid.agendamanger.domain.mapper.ReminderMapper.mapToEntity
import pseudoankit.droid.agendamanger.domain.model.payload.ReminderPayload
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository

internal class ReminderRepositoryImpl(
    private val reminderDao: ReminderDao
) : ReminderRepository {

    override fun save(payload: ReminderPayload) {
        reminderDao.insert(payload.mapToEntity)
    }
}