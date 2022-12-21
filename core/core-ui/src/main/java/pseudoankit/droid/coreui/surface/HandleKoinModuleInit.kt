package pseudoankit.droid.coreui.surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import pseudoankit.droid.core.koin.BaseKoinModule

/**
 * method to avoid duplication of loading / unloading of koin modules
 * @param[module] requires instance of [BaseKoinModule] to load and unload modules
 */
@Composable
fun HandleKoinModuleInit(module: BaseKoinModule, content: @Composable () -> Unit) {
    module.load()
    DisposableEffect(Unit) {
        onDispose {
            module.unload()
        }
    }
    content()
}
