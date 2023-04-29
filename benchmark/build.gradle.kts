plugins {
    id("com.android.test")
    id(Plugins.Core)
}

android {
    namespace = "com.pseudoankit.tasky.benchmark"

    defaultConfig {
        testInstrumentationRunner = BuildConfig.App.TestInstrumentationRunner
    }

    buildTypes {
        // This benchmark buildType is used for benchmarking, and should function like your
        // release build (for example, with minification on). It"s signed with a debug key
        // for easy local/CI testing.
        create("benchmark") {
            isDebuggable = true
            signingConfig = getByName("debug").signingConfig
            matchingFallbacks += listOf("release")
            proguardFiles("benchmark-rules.pro")
        }
    }

    targetProjectPath = ":app"
    experimentalProperties["android.experimental.self-instrumenting"] = true
}

dependencies {
    with(Dependencies) {
        implementation(Benchmark)
    }
    with(Dependencies.Test) {
        implementation(JUnitExt)
        implementation(EspressoCore)
        implementation(UiAutomator)
    }
}

androidComponents {
    beforeVariants(selector().all()) {
        it.enabled = it.buildType == "benchmark"
    }
}