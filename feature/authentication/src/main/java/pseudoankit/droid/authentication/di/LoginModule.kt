package pseudoankit.droid.authentication.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.authentication.domain.LoginUserUseCase
import pseudoankit.droid.authentication.presentation.login.LoginViewModel
import pseudoankit.droid.core.koin.BaseKoinModule

internal object LoginModule : BaseKoinModule() {

    override val modules: Module
        get() = module {
            factory { LoginUserUseCase(get()) }

            viewModel { LoginViewModel(inject(), get()) }
        }
}
