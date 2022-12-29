package pseudoankit.droid.tasky.reminder.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.core.koin.BaseKoinModule
import pseudoankit.droid.tasky.reminder.domain.usecase.SaveReminderUseCase
import pseudoankit.droid.tasky.reminder.presentation.ReminderViewModel

internal object ReminderModule : BaseKoinModule() {
    override val module: Module
        get() = module {
            factory { SaveReminderUseCase() }

            viewModel { ReminderViewModel(get()) }
        }
}