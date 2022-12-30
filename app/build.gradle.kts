plugins {
    id(Plugins.AndroidApplication)
    id(Plugins.Core)
    id(Plugins.Ksp)
    id(Plugins.ComposeCore)
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
        implementation(project(DataBaseManager))
        implementation(project(Navigation))
        implementation(project(AgendaManager))
    }

    with(Dependencies.Koin) {
        implementation(Compose)
    }

    with(Dependencies.Compose) {
        implementation(ComposeDestinations)
    }
}
