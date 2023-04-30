package com.pseudoankit.tasky.benchmark

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
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
    fun startUpCompilationPartial() = startup(CompilationMode.Partial())

    @Test
    fun startUpCompilationNone() = startup(CompilationMode.None())

    @Test
    fun homeScreenTestCompilationPartial() = homeScreenTest(CompilationMode.Partial())

    @Test
    fun homeScreenTestCompilationNone() = homeScreenTest(CompilationMode.None())

    private fun startup(compilationMode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = PackageName,
        metrics = listOf(StartupTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD,
        compilationMode = compilationMode
    ) {
        openApplication()
    }

    private fun homeScreenTest(compilationMode: CompilationMode) = benchmarkRule.measureRepeated(
        packageName = PackageName,
        metrics = listOf(FrameTimingMetric()),
        iterations = 5,
        startupMode = StartupMode.COLD,
        compilationMode = compilationMode
    ) {
        performHomeScreenOperations()
    }
}
