object Dependencies {

    const val DataStore = "androidx.datastore:datastore-preferences:1.1.0-alpha01"
    const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:2.9.1"
    const val ProfilerInstaller = "androidx.profileinstaller:profileinstaller:1.3.0"
    const val Benchmark = "androidx.benchmark:benchmark-macro-junit4:1.2.0-alpha13"

    object Core {
        const val Core = "androidx.core:core:1.10.0"
        const val AppShortcut = "androidx.core:core-google-shortcuts:1.1.0"
        const val SplashScreen = "androidx.core:core-splashscreen:1.0.0-beta02"
    }

    object Compose {
        const val Bom = "androidx.compose:compose-bom:2023.01.00"
        const val Activity = "androidx.activity:activity-compose:"
        const val Material = "androidx.compose.material:material:"
        const val Material3 = "androidx.compose.material3:material3:"
        const val Ui = "androidx.compose.ui:ui:"
        const val UiTooling = "androidx.compose.ui:ui-tooling:"
        const val UiToolingPreview = "androidx.compose.ui:ui-tooling-preview:"
        const val FoundationLayout = "androidx.compose.foundation:foundation-layout:"
        const val Foundation = "androidx.compose.foundation:foundation:"
        const val Compiler = "androidx.compose.compiler:compiler:"
        const val ConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:"

        const val Runtime = "androidx.compose.runtime:runtime:${Versions.Compose.Core}"

        const val ComposeDestinations =
            "io.github.raamcosta.compose-destinations:animations-core:${Versions.Compose.Destinations}"
        const val ComposeDestinationsKsp =
            "io.github.raamcosta.compose-destinations:ksp:${Versions.Compose.Destinations}"
        const val DatePicker = "io.github.vanpra.compose-material-dialogs:datetime:0.8.1-rc"
        const val FontAwesome = "com.github.pseudoankit:ComposeFontAwesomeLibrary:v1.2.0"
        const val OrbitMvi = "org.orbit-mvi:orbit-compose:4.5.0"
        const val SwipeableCard = "com.github.pseudoankit:SwipeableView:1.0.1"

        const val CoilCompose = "io.coil-kt:coil-compose:${Versions.Compose.Coil}"
        const val CoilSvg = "io.coil-kt:coil-svg:${Versions.Compose.Coil}"

        const val Pager = "com.google.accompanist:accompanist-pager:0.23.1"
        const val PagerIndicator = "com.google.accompanist:accompanist-pager-indicators:0.23.1"
        const val Permissions = "com.google.accompanist:accompanist-permissions:0.23.1"
        const val PlaceHolder =
            "com.google.accompanist:accompanist-placeholder-material:0.26.3-beta"
    }

    object Koin {
        const val Core = "io.insert-koin:koin-core:${Versions.Koin.Core}"
        const val Android = "io.insert-koin:koin-android:${Versions.Koin.Core}"
        const val Compose = "io.insert-koin:koin-androidx-compose:${Versions.Koin.Compose}"
    }

    object Kotlin {
        const val ImmutableCollection = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5"
        const val Serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"

        object Coroutine {
            const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutine}"
            const val Android =
                "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutine}"
        }
    }

    object Gradle {
        const val AndroidTools = "com.android.tools.build:gradle:${Versions.Gradle.AndroidTools}"
        const val KotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}"
        const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:1.1.2"
        const val PluginsRepo = "https://plugins.gradle.org/m2/"
    }

    object Room {
        const val Runtime = "androidx.room:room-runtime:${Versions.Room}"
        const val Compiler = "androidx.room:room-compiler:${Versions.Room}"
        const val Ktx = "androidx.room:room-ktx:${Versions.Room}"
    }

    object Test {
        const val JUnitExt = "androidx.test.ext:junit:1.1.5"
        const val EspressoCore = "androidx.test.espresso:espresso-core:3.5.1"
        const val UiAutomator = "androidx.test.uiautomator:uiautomator:2.2.0"
    }
}
