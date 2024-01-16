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
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile(BuildConfig.App.DefaultProguardOptimizeFile),
                BuildConfig.App.ProGuardRules
            )
        }
        create("benchmark") {
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }
    }
}

dependencies {
    with(Modules.Core) {
        implementation(project(DesignSystem))
        implementation(project(Core))
        implementation(project(CoreUi))
        implementation(project(DataBaseManager))
        implementation(project(AgendaManager))
        implementation(project(AlarmManager))
        implementation(project(NotificationManager))
        implementation(project(PermissionManager))
        implementation(project(PreferencesManager))
        implementation(project(AppShortcuts))
    }

    with(Modules.Feature) {
        implementation(project(Authentication))
        implementation(project(Home))
        implementation(project(Event))
        implementation(project(Reminder))
        implementation(project(Task))
        implementation(project(DeveloperTools))
    }

    with(Dependencies.Compose) {
        implementation(ComposeDestinations)
        implementation(OrbitMvi)
    }

    implementation(Dependencies.Koin.Compose)
    implementation(Dependencies.AndroidX.SplashScreen)
    implementation(Dependencies.ProfilerInstaller)
}
