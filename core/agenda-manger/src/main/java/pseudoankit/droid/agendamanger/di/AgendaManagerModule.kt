package pseudoankit.droid.agendamanger.di

import org.koin.dsl.module
import pseudoankit.droid.agendamanger.data.repository.AgendaRepositoryImpl
import pseudoankit.droid.agendamanger.data.repository.ReminderRepositoryImpl
import pseudoankit.droid.agendamanger.domain.repository.AgendaRepository
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepository
import pseudoankit.droid.agendamanger.domain.repository.ReminderRepositoryInternal
import pseudoankit.droid.agendamanger.domain.usecase.reminder.SaveReminderUseCase
import pseudoankit.droid.agendamanger.domain.usecase.reminder.TriggerAlarmUseCase
import pseudoankit.droid.core.widget.UpdateAppWidgetFlowInstance

// TODO move to individual screen
object AgendaManagerModule {

    operator fun invoke() = module {
        single { SaveReminderUseCase(UpdateAppWidgetFlowInstance) }
        single { TriggerAlarmUseCase(get()) }

        single<ReminderRepositoryInternal> { ReminderRepositoryImpl(get()) }
        single<ReminderRepository> { ReminderRepositoryImpl(get()) }
        single<AgendaRepository> { AgendaRepositoryImpl(get()) }
    }
}