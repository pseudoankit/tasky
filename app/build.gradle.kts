plugins {
    id(Plugins.App.Android)
}

apply {
    applyTaskyCore(rootDir)
    applyTaskyCompose(rootDir)
}

android {
    namespace = "pseudoankit.droid.tasky"

    defaultConfig {
        applicationId = BuildConfig.App.ApplicationId
        versionCode = BuildConfig.App.VersionCode
        versionName =  BuildConfig.App.VersionName
        testInstrumentationRunner = BuildConfig.TestInstrumentationRunner

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(BuildConfig.DefaultProguardOptimizeFile),
                BuildConfig.ProGuardRules
            )
        }
    }
}
