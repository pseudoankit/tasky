package pseudoankit.droid.agendamanger.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.AgendaRepository
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import java.time.LocalDate

// TODO sorting for all agenda types
internal class AgendaRepositoryImpl(
    private val reminderRepository: ReminderRepository
) : AgendaRepository {

    override fun getAllSavedItemFlow(selectedDate: LocalDate?): Flow<List<AgendaItem>> {
        return combine(
            reminderRepository.getReminders(selectedDate)
        ) { items ->
            items[0]
        }
    }

    override fun getAllSavedItem(): List<AgendaItem> {
        val reminderItems = reminderRepository.getReminders()
        // combine others

        return reminderItems
    }
}