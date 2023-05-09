package com.pseudoankit.test_helper

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import pseudoankit.droid.core.dispatcher.DispatcherProvider

class TestCoroutineDispatcherProvider(
    private val dispatcher: CoroutineDispatcher
) : DispatcherProvider {

    override val io: CoroutineDispatcher
        get() = dispatcher
    override val default: CoroutineDispatcher
        get() = dispatcher

    override suspend fun <T> switchToIo(block: suspend CoroutineScope.() -> T): T {
        return withContext(dispatcher) {
            block()
        }
    }

    override suspend fun <T> switchToDefault(block: suspend CoroutineScope.() -> T): T {
        return withContext(dispatcher) {
            block()
        }
    }
}
