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
    implementation(projects.core.designSystem)
    implementation(projects.core.core)
    implementation(projects.core.coreUi)
    implementation(projects.core.databaseManager)
    implementation(projects.core.agendaManger)
    implementation(projects.core.alarmManager)
    implementation(projects.core.notificationManager)
    implementation(projects.core.permissionManager)
    implementation(projects.core.preferencesManager)
    implementation(projects.core.appShortcutsNWidgets)

    implementation(projects.feature.authentication)
    implementation(projects.feature.home)
    implementation(projects.feature.agenda.event)
    implementation(projects.feature.agenda.reminder)
    implementation(projects.feature.agenda.task)
    implementation(projects.feature.developerTools)

    implementation(libs.compose.destinations)
    implementation(libs.compose.orbit.mvi)

    implementation(libs.koin.compose)
    implementation(libs.androidx.splashScreen)
    implementation(libs.androidx.profilerInstaller)
}
