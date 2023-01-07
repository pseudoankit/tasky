package pseudoankit.droid.core.koin

import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class BaseKoinModule {
    private var isLoaded = false

    abstract val provideModules: List<Module>

    fun loadModules() {
        if (isLoaded) return

        isLoaded = true
        loadKoinModules(provideModules)
    }

    fun unloadModules() {
        if (isLoaded.not()) return

        isLoaded = false
        unloadKoinModules(provideModules)
    }
}