package pseudoankit.droid.agendamanger.data.repository

import kotlinx.coroutines.flow.Flow
import pseudoankit.droid.agendamanger.data.local.dao.ReminderDao
import pseudoankit.droid.agendamanger.data.local.entity.ReminderEntity
import pseudoankit.droid.agendamanger.domain.mapper.ReminderMapper.mapToEntity
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import java.time.LocalDate

internal class ReminderRepositoryImpl(
    private val dao: ReminderDao
) : ReminderRepository {

    override fun getReminders(date: LocalDate): Flow<List<ReminderEntity>> {
        return dao.getReminders(date)
    }

    override suspend fun save(payload: AgendaItem.Reminder) {
        dao.insert(payload.mapToEntity)
    }

    override suspend fun update(payload: AgendaItem.Reminder) {
        dao.update(payload.mapToEntity)
    }
}