plugins {
    id(Plugins.AndroidApplication)
    id(Plugins.Core)
    id(Plugins.Ksp)
}

android {
    namespace = "pseudoankit.droid.tasky"

    defaultConfig {
        applicationId = BuildConfig.App.ApplicationId
        versionCode = BuildConfig.App.VersionCode
        versionName = BuildConfig.App.VersionName
        testInstrumentationRunner = BuildConfig.App.TestInstrumentationRunner

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Compiler
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(BuildConfig.App.DefaultProguardOptimizeFile),
                BuildConfig.App.ProGuardRules
            )
        }
    }
}

dependencies {
    with(Modules.Core) {
        implementation(project(DesignSystem))
        implementation(project(Core))
        implementation(project(CoreUi))
    }

    with(Modules.Feature) {
        implementation(project(Authentication))
        implementation(project(Home))
        implementation(project(Event))
        implementation(project(Reminder))
        implementation(project(Task))
    }

    with(Dependencies.Koin) {
        implementation(Compose)
    }

    with(Dependencies.Compose) {
        implementation(Ui)
        implementation(Runtime)
        implementation(FoundationLayout)
        implementation(UiToolingPreview)
        implementation(UiTooling)
        implementation(Material3)
        implementation(Activity)
        implementation(ComposeDestinations)
        ksp(ComposeDestinationsKsp)
    }
}
