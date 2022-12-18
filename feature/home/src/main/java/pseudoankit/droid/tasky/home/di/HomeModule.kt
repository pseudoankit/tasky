package pseudoankit.droid.tasky.home.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.core.koin.BaseKoinModule
import pseudoankit.droid.tasky.home.presentation.HomeViewModel

object HomeModule : BaseKoinModule() {

    override val module: Module
        get() = module {
            viewModel { HomeViewModel() }
        }
}