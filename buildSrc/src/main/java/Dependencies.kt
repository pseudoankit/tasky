object Dependencies {
    object Compose {
        const val Activity = "androidx.activity:activity-compose:${Versions.Compose.Activity}"
        const val Material = "androidx.compose.material:material:${Versions.Compose.Core}"
        const val Material3 = "androidx.compose.material3:material3:${Versions.Compose.Material3}"
        const val Ui = "androidx.compose.ui:ui:${Versions.Compose.Core}"
        const val UiTooling = "androidx.compose.ui:ui-tooling:${Versions.Compose.Core}"
        const val UiToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.Core}"
        const val Runtime = "androidx.compose.runtime:runtime:${Versions.Compose.Core}"
        const val FoundationLayout =
            "androidx.compose.foundation:foundation-layout:${Versions.Compose.Core}"
        const val Foundation = "androidx.compose.foundation:foundation:${Versions.Compose.Core}"
        const val Compiler = "androidx.compose.compiler:compiler:${Versions.Compose.Core}"
        const val ComposeDestinations =
            "io.github.raamcosta.compose-destinations:animations-core:${Versions.Compose.Destinations}"
        const val ComposeDestinationsKsp =
            "io.github.raamcosta.compose-destinations:ksp:${Versions.Compose.Destinations}"
        const val ConstraintLayout =
            "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.ConstraintLayout}"
        const val DatePicker = "io.github.vanpra.compose-material-dialogs:datetime:0.8.1-rc"
        const val FontAwesome = "com.github.pseudoankit:ComposeFontAwesomeLibrary:v1.2.0"
        const val OrbitMvi = "org.orbit-mvi:orbit-compose:4.5.0"
    }

    object Koin {
        const val Core = "io.insert-koin:koin-core:${Versions.Koin.Core}"
        const val Android = "io.insert-koin:koin-android:${Versions.Koin.Core}"
        const val Compose = "io.insert-koin:koin-androidx-compose:${Versions.Koin.Compose}"
    }

    object Kotlin {
        const val ImmutableCollection = "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5"
        const val CoroutineCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutine}"
        const val CoroutineAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutine}"
        const val Serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1"
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
}
