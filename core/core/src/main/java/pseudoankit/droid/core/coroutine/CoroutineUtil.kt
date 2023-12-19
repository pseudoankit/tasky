package pseudoankit.droid.core.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun launchCoroutine(
    dispatcher: CoroutineContext = Dispatchers.IO,
    block: suspend CoroutineScope.() -> Unit
): Job {
    return CoroutineScope(dispatcher).launch {
        block()
    }
}
