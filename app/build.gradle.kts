plugins {
    id("com.android.application")
    id(Plugins.Core)
    id(Plugins.Ksp)
    id(Plugins.ComposeCore)
}

android {
    namespace = "pseudoankit.droid.tasky"

    defaultConfig {
        applicationId = "pseudoankit.droid.tasky"
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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

    implementation(libs.compose.destinations)
    implementation(libs.compose.orbit.mvi)

    implementation(libs.koin.compose)
    implementation(libs.androidx.splashScreen)
    implementation(libs.androidx.profilerInstaller)
}
