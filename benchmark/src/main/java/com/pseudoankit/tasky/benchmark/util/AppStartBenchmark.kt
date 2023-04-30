package com.pseudoankit.tasky.benchmark.util

import androidx.benchmark.macro.MacrobenchmarkScope

fun MacrobenchmarkScope.openApplication() {
    pressHome()
    startActivityAndWait()
}