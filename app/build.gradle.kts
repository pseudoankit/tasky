plugins {
    id(Plugins.Application)
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
    }

    with(Modules.Feature) {
        implementation(project(Authentication))
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
