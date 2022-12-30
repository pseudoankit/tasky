package pseudoankit.droid.agendamanger.domain.repository

import kotlinx.coroutines.flow.Flow
import pseudoankit.droid.agendamanger.data.local.entity.ReminderEntity
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import java.time.LocalDate

interface ReminderRepository {
    fun getReminders(date: LocalDate): Flow<List<ReminderEntity>>
    fun save(payload: AgendaItem.Reminder)
}