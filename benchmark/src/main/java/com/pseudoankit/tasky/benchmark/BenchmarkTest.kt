package com.pseudoankit.tasky.benchmark

import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pseudoankit.tasky.benchmark.util.PackageName
import com.pseudoankit.tasky.benchmark.util.openApplication
import com.pseudoankit.tasky.benchmark.util.performHomeScreenOperations
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BenchmarkTest {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startup() = benchmarkRule.measureRepeated(
        packageName = PackageName,
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD
    ) {
        openApplication()
    }

    @Test
    fun homeScreenTest() = benchmarkRule.measureRepeated(
        packageName = PackageName,
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD
    ) {
        performHomeScreenOperations()
    }
}