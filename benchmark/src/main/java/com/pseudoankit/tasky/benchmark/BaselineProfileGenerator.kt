package com.pseudoankit.tasky.benchmark

import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pseudoankit.tasky.benchmark.util.PackageName
import com.pseudoankit.tasky.benchmark.util.performHomeScreenOperations
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*
 * to generate run
 * ./gradlew :benchmark:pixelapi31BenchmarkAndroidTest -P android.testInstrumentationRunnerArguments.androidx.benchmark.enabledRules=BaselineProfile
 */

@RunWith(AndroidJUnit4::class)
class BaselineProfileGenerator {

    @get:Rule
    val rule = BaselineProfileRule()

    @Test
    fun homeScreenTest() = rule.collectBaselineProfile(
        packageName = PackageName
    ) {
        performHomeScreenOperations()
    }
}
