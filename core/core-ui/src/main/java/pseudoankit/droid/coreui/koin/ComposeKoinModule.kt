package pseudoankit.droid.coreui.koin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import pseudoankit.droid.core.koin.BaseKoinModule

/**
 * method to manage loading / unloading of koin modules
 * @param[module] requires instance of [BaseKoinModule] to load and unload modules
 */
@Composable
fun BaseKoinModule.load(content: @Composable () -> Unit) {
    loadModules()
    DisposableEffect(Unit) {
        onDispose {
            unloadModules()
        }
    }
    content()
}

/**
 * method to manage loading / unloading of koin modules
 * @param[module] requires instance of [BaseKoinModule] to load and unload modules
 */
@Composable
fun BaseKoinModule.load() {
    loadModules()
    DisposableEffect(Unit) {
        onDispose {
            unloadModules()
        }
    }
}
