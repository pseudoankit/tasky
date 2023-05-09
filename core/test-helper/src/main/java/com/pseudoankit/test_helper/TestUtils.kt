package com.pseudoankit.test_helper

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher

fun TestScope.launchInTestScope(block: suspend CoroutineScope.() -> Unit): Job {
    return launch(UnconfinedTestDispatcher(testScheduler)) {
        block()
    }
}
