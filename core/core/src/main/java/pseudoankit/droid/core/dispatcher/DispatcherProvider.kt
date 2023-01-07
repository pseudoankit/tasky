package pseudoankit.droid.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

interface DispatcherProvider {
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    suspend fun <T> switchToIo(block: CoroutineScope.() -> T)
    suspend fun <T> switchToDefault(block: CoroutineScope.() -> T)
}