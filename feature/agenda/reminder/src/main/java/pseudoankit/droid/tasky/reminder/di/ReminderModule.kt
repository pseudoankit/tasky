package pseudoankit.droid.tasky.reminder.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.core.koin.BaseKoinModule
import pseudoankit.droid.tasky.reminder.domain.usecase.SaveReminderUseCase
import pseudoankit.droid.tasky.reminder.domain.usecase.TriggerAlarmUseCase
import pseudoankit.droid.tasky.reminder.presentation.ReminderViewModel

internal object ReminderModule : BaseKoinModule() {

    override val provideModules: List<Module>
        get() = listOf(
            module {
                factory { TriggerAlarmUseCase(get()) }
                factory { SaveReminderUseCase(get(), get()) }

                viewModel { ReminderViewModel(get(), get()) }
            }
        )
}