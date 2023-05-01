package pseudoankit.droid.tasky.home.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.agendamanger.domain.usecase.reminder.GetSavedAgendaItemsUseCase
import pseudoankit.droid.core.koin.BaseKoinModule
import pseudoankit.droid.tasky.home.domain.usecase.DeleteAgendaUseCase
import pseudoankit.droid.tasky.home.domain.usecase.ToggleAgendaItemCompletionUseCase
import pseudoankit.droid.tasky.home.presentation.home.HomeViewModel
import pseudoankit.droid.tasky.home.presentation.taskyitems.AgendaItemsViewModel

internal object HomeModule : BaseKoinModule() {

    override val provideModules: List<Module>
        get() = listOf(
            module {
                factory { GetSavedAgendaItemsUseCase(get()) }
                factory { ToggleAgendaItemCompletionUseCase(get(), get(), get()) }
                factory { DeleteAgendaUseCase(get()) }

                viewModel { AgendaItemsViewModel() }
                viewModel { HomeViewModel(get(), get(), get()) }
            }
        )
}