package pseudoankit.droid.agendamanger.domain.repository

import kotlinx.coroutines.flow.Flow
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import java.time.LocalDate

interface ReminderRepository {
    fun getReminders(date: LocalDate?): Flow<List<AgendaItem.Reminder>>
    fun getReminders(): List<AgendaItem.Reminder>
    fun getReminder(id: Long): AgendaItem.Reminder
    suspend fun delete(payload: AgendaItem.Reminder)
}

internal interface ReminderRepositoryInternal {
    suspend fun save(payload: AgendaItem.Reminder)
    suspend fun update(payload: AgendaItem.Reminder)
}