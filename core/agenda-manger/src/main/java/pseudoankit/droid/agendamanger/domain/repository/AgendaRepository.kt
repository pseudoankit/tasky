package pseudoankit.droid.agendamanger.domain.repository

import kotlinx.coroutines.flow.Flow
import pseudoankit.droid.agendamanger.domain.model.AgendaItem

interface AgendaRepository {

    fun getAllSavedItem(): Flow<List<AgendaItem>>
}