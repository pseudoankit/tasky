package pseudoankit.droid.core.koin

import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class BaseKoinModule {
    private var isLoaded = false

    abstract val modules: Module

    fun loadModules() {
        if (isLoaded) return

        isLoaded = true
        loadKoinModules(modules)
    }

    fun unloadModules() {
        if (isLoaded.not()) return

        isLoaded = false
        unloadKoinModules(modules)
    }
}