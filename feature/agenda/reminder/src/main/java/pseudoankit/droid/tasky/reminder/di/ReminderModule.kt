package pseudoankit.droid.tasky.reminder.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.core.koin.BaseKoinModule
import pseudoankit.droid.tasky.reminder.presentation.ReminderViewModel

internal object ReminderModule : BaseKoinModule() {

    override val provideModules: List<Module>
        get() = listOf(
            module {
                viewModel { ReminderViewModel(get(), get(), get()) }
            }
        )
}