package pseudoankit.droid.authentication.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.authentication.domain.LoginUseCase
import pseudoankit.droid.authentication.presentation.login.LoginViewModel
import pseudoankit.droid.core.koin.BaseKoinModule

internal object LoginModule : BaseKoinModule() {

    override val provideModules: List<Module>
        get() = listOf(
            module {
                factory { LoginUseCase(get()) }

                viewModel { LoginViewModel(get()) }
            }
        )
}
