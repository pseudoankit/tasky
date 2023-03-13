object Dependencies {
    private fun <T> nonThreadSafeLazy(initializer: () -> T) =
        lazy(LazyThreadSafetyMode.NONE, initializer)

    val DataStore by nonThreadSafeLazy { "androidx.datastore:datastore-preferences:1.1.0-alpha01" }

    object Compose {
        val Bom = "androidx.compose:compose-bom:2023.01.00"
        val Activity = "androidx.activity:activity-compose:"
        val Material = "androidx.compose.material:material:"
        val Material3 = "androidx.compose.material3:material3:"
        val Ui = "androidx.compose.ui:ui:"
        val UiTooling = "androidx.compose.ui:ui-tooling:"
        val UiToolingPreview = "androidx.compose.ui:ui-tooling-preview:"
        val FoundationLayout = "androidx.compose.foundation:foundation-layout:"
        val Foundation = "androidx.compose.foundation:foundation:"
        val Compiler = "androidx.compose.compiler:compiler:"
        val ConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:"

        val Runtime = "androidx.compose.runtime:runtime:${Versions.Compose.Core}"

        val ComposeDestinations = "io.github.raamcosta.compose-destinations:animations-core:${Versions.Compose.Destinations}"
        val ComposeDestinationsKsp = "io.github.raamcosta.compose-destinations:ksp:${Versions.Compose.Destinations}"
        val DatePicker = "io.github.vanpra.compose-material-dialogs:datetime:0.8.1-rc"
        val FontAwesome = "com.github.pseudoankit:ComposeFontAwesomeLibrary:v1.2.0"
        val OrbitMvi = "org.orbit-mvi:orbit-compose:4.5.0"
        
        val CoilCompose = "io.coil-kt:coil-compose:${Versions.Compose.Coil}"
        val CoilSvg = "io.coil-kt:coil-svg:${Versions.Compose.Coil}"

        val Pager = "com.google.accompanist:accompanist-pager:0.23.1"
        val PagerIndicator = "com.google.accompanist:accompanist-pager-indicators:0.23.1"
        val Permissions = "com.google.accompanist:accompanist-permissions:0.23.1"
        val PlaceHolder = "com.google.accompanist:accompanist-placeholder-material:0.26.3-beta"
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
