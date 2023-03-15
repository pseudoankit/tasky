package pseudoankit.droid.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

interface DispatcherProvider {
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    suspend fun <T> switchToIo(block: suspend CoroutineScope.() -> T): T
    suspend fun <T> switchToDefault(block: suspend CoroutineScope.() -> T): T
}