object Dependencies {
    private fun <T> nonThreadSafeLazy(initializer: () -> T) =
        lazy(LazyThreadSafetyMode.NONE, initializer)

    val DataStore by nonThreadSafeLazy { "androidx.datastore:datastore-preferences:1.1.0-alpha01" }

    object Compose {
        val Activity by nonThreadSafeLazy { "androidx.activity:activity-compose:${Versions.Compose.Activity}" }
        val Material by nonThreadSafeLazy { "androidx.compose.material:material:${Versions.Compose.Core}" }
        val Material3 by nonThreadSafeLazy { "androidx.compose.material3:material3:${Versions.Compose.Material3}" }
        val Ui by nonThreadSafeLazy { "androidx.compose.ui:ui:${Versions.Compose.Core}" }
        val UiTooling by nonThreadSafeLazy { "androidx.compose.ui:ui-tooling:${Versions.Compose.Core}" }
        val UiToolingPreview by nonThreadSafeLazy { "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.Core}" }
        val Runtime by nonThreadSafeLazy { "androidx.compose.runtime:runtime:${Versions.Compose.Core}" }
        val FoundationLayout by nonThreadSafeLazy { "androidx.compose.foundation:foundation-layout:${Versions.Compose.Core}" }
        val Foundation by nonThreadSafeLazy { "androidx.compose.foundation:foundation:${Versions.Compose.Core}" }
        val Compiler by nonThreadSafeLazy { "androidx.compose.compiler:compiler:${Versions.Compose.Core}" }
        val ComposeDestinations by nonThreadSafeLazy { "io.github.raamcosta.compose-destinations:animations-core:${Versions.Compose.Destinations}" }
        val ComposeDestinationsKsp by nonThreadSafeLazy { "io.github.raamcosta.compose-destinations:ksp:${Versions.Compose.Destinations}" }
        val ConstraintLayout by nonThreadSafeLazy { "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.ConstraintLayout}" }
        val DatePicker by nonThreadSafeLazy { "io.github.vanpra.compose-material-dialogs:datetime:0.8.1-rc" }
        val FontAwesome by nonThreadSafeLazy { "com.github.pseudoankit:ComposeFontAwesomeLibrary:v1.2.0" }
        val OrbitMvi by nonThreadSafeLazy { "org.orbit-mvi:orbit-compose:4.5.0" }
        val CoilCompose by nonThreadSafeLazy { "io.coil-kt:coil-compose:${Versions.Compose.Coil}" }
        val CoilSvg by nonThreadSafeLazy { "io.coil-kt:coil-svg:${Versions.Compose.Coil}" }
        val Pager by nonThreadSafeLazy { "com.google.accompanist:accompanist-pager:0.23.1" }
        val PagerIndicator by nonThreadSafeLazy { "com.google.accompanist:accompanist-pager-indicators:0.23.1" }
        val Permissions by nonThreadSafeLazy { "com.google.accompanist:accompanist-permissions:0.23.1" }
        val PlaceHolder by nonThreadSafeLazy { "com.google.accompanist:accompanist-placeholder-material:0.26.3-beta" }
    }

    object Koin {
        val Core by nonThreadSafeLazy { "io.insert-koin:koin-core:${Versions.Koin.Core}" }
        val Android by nonThreadSafeLazy { "io.insert-koin:koin-android:${Versions.Koin.Core}" }
        val Compose by nonThreadSafeLazy { "io.insert-koin:koin-androidx-compose:${Versions.Koin.Compose}" }
    }

    object Kotlin {
        val ImmutableCollection by nonThreadSafeLazy { "org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5" }
        val Serialization by nonThreadSafeLazy { "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1" }

        object Coroutine {
            val Core by nonThreadSafeLazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutine}" }
            val Android by nonThreadSafeLazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutine}" }
        }
    }

    object Gradle {
        val AndroidTools by nonThreadSafeLazy { "com.android.tools.build:gradle:${Versions.Gradle.AndroidTools}" }
        val KotlinGradle by nonThreadSafeLazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}" }
        val Kotlin by nonThreadSafeLazy { "org.jetbrains.kotlin:kotlin-stdlib:1.1.2" }
        val PluginsRepo by nonThreadSafeLazy { "https://plugins.gradle.org/m2/" }
    }

    object Room {
        val Runtime by nonThreadSafeLazy { "androidx.room:room-runtime:${Versions.Room}" }
        val Compiler by nonThreadSafeLazy { "androidx.room:room-compiler:${Versions.Room}" }
        val Ktx by nonThreadSafeLazy { "androidx.room:room-ktx:${Versions.Room}" }
    }
}
