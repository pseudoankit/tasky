package pseudoankit.droid.agendamanger.di

import org.koin.dsl.module
import pseudoankit.droid.agendamanger.data.repository.AgendaRepositoryImpl
import pseudoankit.droid.agendamanger.data.repository.ReminderRepositoryImpl
import pseudoankit.droid.agendamanger.domain.repository.AgendaRepository
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository

object AgendaManagerModule {

    operator fun invoke() = module {
        factory<ReminderRepository> { ReminderRepositoryImpl(get()) }
        factory<AgendaRepository> { AgendaRepositoryImpl(get()) }
    }
}