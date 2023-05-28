package pseudoankit.droid.agendamanger.domain.repository

import kotlinx.coroutines.flow.Flow
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import java.time.LocalDate

interface AgendaRepository {

    fun getAllSavedItem(selectedDate: LocalDate? = null): Flow<List<AgendaItem>>
}