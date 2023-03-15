package pseudoankit.droid.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class DispatcherProviderImpl : DispatcherProvider {

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val default: CoroutineDispatcher
        get() = Dispatchers.Default

    override suspend fun <T> switchToDefault(block: suspend CoroutineScope.() -> T): T {
        return withContext(context = default, block = block)
    }

    override suspend fun <T> switchToIo(block: suspend CoroutineScope.() -> T): T {
        return withContext(context = io, block = block)
    }
}