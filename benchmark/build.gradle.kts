import com.android.build.api.dsl.ManagedVirtualDevice

plugins {
    id("com.android.test")
    id(Plugins.Core)
}

android {
    namespace = "com.pseudoankit.tasky.benchmark"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    testOptions {
        managedDevices {
            devices {
                create("pixelapi31", ManagedVirtualDevice::class) {
                    device = "Pixel"
                    apiLevel = 31
                    systemImageSource = "aosp"
                }
            }
        }
    }

    targetProjectPath = ":app"
    experimentalProperties["android.experimental.self-instrumenting"] = true
}

dependencies {
    with(Modules.Core) {
        implementation(project(Core))
    }

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