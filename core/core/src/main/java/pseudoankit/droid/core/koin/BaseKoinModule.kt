package pseudoankit.droid.core.koin

import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class BaseKoinModule {
    var isLoaded = false

    abstract val module: Module

    fun load() {
        if (isLoaded) return

        isLoaded = true
        loadKoinModules(module)
    }

    fun unload() {
        if (isLoaded.not()) return

        isLoaded = false
        unloadKoinModules(module)
    }
}