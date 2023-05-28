package pseudoankit.droid.agendamanger.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pseudoankit.droid.agendamanger.data.local.dao.ReminderDao
import pseudoankit.droid.agendamanger.domain.mapper.ReminderMapper.mapToDomain
import pseudoankit.droid.agendamanger.domain.mapper.ReminderMapper.mapToEntity
import pseudoankit.droid.agendamanger.domain.mapper.ReminderMapper.sortByAscDateTime
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepositoryInternal
import java.time.LocalDate

// TODO thread switching in repo
internal class ReminderRepositoryImpl(
    private val dao: ReminderDao
) : ReminderRepository, ReminderRepositoryInternal {

    override fun getReminders(): List<AgendaItem.Reminder> {
        return dao.getReminders()
            .map { it.mapToDomain }
            .sortByAscDateTime
    }

    override fun getReminder(id: Long): AgendaItem.Reminder {
        return dao.getReminder(id).mapToDomain
    }

    override fun getReminders(date: LocalDate?): Flow<List<AgendaItem.Reminder>> {
        val reminders = if (date != null) {
            dao.getRemindersFlow(date)
        } else {
            dao.getRemindersFlow()
        }

        return reminders
            .map { list ->
                list.map {
                    it.mapToDomain
                }.sortByAscDateTime
            }
    }

    override suspend fun save(payload: AgendaItem.Reminder) {
        dao.insert(payload.mapToEntity)
    }

    override suspend fun update(payload: AgendaItem.Reminder) {
        dao.update(payload.mapToEntity)
    }

    override suspend fun delete(payload: AgendaItem.Reminder) {
        dao.delete(payload.mapToEntity)
    }
}