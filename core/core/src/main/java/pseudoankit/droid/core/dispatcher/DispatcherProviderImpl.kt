package pseudoankit.droid.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class DispatcherProviderImpl : DispatcherProvider {

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val default: CoroutineDispatcher
        get() = Dispatchers.Main

    override suspend fun <T> switchToDefault(block: CoroutineScope.() -> T) {
        withContext(context = default, block = block)
    }

    override suspend fun <T> switchToIo(block: CoroutineScope.() -> T) {
        withContext(context = io, block = block)
    }
}