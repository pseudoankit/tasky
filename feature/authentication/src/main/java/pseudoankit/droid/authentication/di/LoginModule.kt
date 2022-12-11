package pseudoankit.droid.authentication.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module
import pseudoankit.droid.authentication.presentation.login.LoginViewModel

object LoginModule {
    private val module = module {
        viewModel { LoginViewModel() }
    }

    fun load() {
        loadKoinModules(module)
    }

    fun unload() {
        unloadKoinModules(module)
    }
}
