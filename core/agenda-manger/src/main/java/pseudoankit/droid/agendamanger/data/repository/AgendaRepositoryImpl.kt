package pseudoankit.droid.agendamanger.data.repository

import kotlinx.coroutines.flow.Flow
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.AgendaRepository

internal class AgendaRepositoryImpl : AgendaRepository {

    override fun getAllSavedItem(): Flow<List<AgendaItem>> {
        TODO("Not yet implemented")
    }

}