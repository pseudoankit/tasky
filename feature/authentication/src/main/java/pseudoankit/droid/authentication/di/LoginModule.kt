package pseudoankit.droid.authentication.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.authentication.presentation.login.LoginViewModel
import pseudoankit.droid.core.koin.CoreModule

internal object LoginModule : CoreModule() {
    override val module: Module
        get() = module {
            viewModel { LoginViewModel() }
        }
}
