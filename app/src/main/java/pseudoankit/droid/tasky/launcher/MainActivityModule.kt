package pseudoankit.droid.tasky.launcher

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import pseudoankit.droid.core.koin.BaseKoinModule

object MainActivityModule : BaseKoinModule() {

    override val modules: Module
        get() = module {
            viewModel { MainActivityViewModel(get()) }
        }
}