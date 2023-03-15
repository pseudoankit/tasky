package pseudoankit.droid.authentication.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.authentication.domain.RegisterUserUseCase
import pseudoankit.droid.authentication.presentation.registration.RegistrationViewModel
import pseudoankit.droid.core.koin.BaseKoinModule

internal object RegistrationModule : BaseKoinModule() {

    override val provideModules: List<Module>
        get() = listOf(
            module {
                factory { RegisterUserUseCase() }
                viewModel { RegistrationViewModel(get(), get()) }
            }
        )
}