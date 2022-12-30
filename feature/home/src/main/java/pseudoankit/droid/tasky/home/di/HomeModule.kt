package pseudoankit.droid.tasky.home.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.core.koin.BaseKoinModule
import pseudoankit.droid.tasky.home.domain.usecase.GetSavedAgendaItemsUseCase
import pseudoankit.droid.tasky.home.presentation.home.HomeViewModel
import pseudoankit.droid.tasky.home.presentation.taskyitems.AgendaItemsViewModel

internal object HomeModule : BaseKoinModule() {

    override val modules: List<Module>
        get() = listOf(
            module {
                viewModel { AgendaItemsViewModel() }
                factory { GetSavedAgendaItemsUseCase(get()) }
                viewModel { HomeViewModel(get()) }
            }
        )
}