object Dependencies {

    object Compose {

        const val ComposeDestinations =
            "io.github.raamcosta.compose-destinations:animations-core:${Versions.Compose.Destinations}"
        const val ComposeDestinationsKsp =
            "io.github.raamcosta.compose-destinations:ksp:${Versions.Compose.Destinations}"
        const val DatePicker = "io.github.vanpra.compose-material-dialogs:datetime:0.8.1-rc"
        const val FontAwesome = "com.github.pseudoankit:ComposeFontAwesomeLibrary:v1.2.0"
        const val OrbitMvi = "org.orbit-mvi:orbit-compose:${Versions.Compose.OrbitMvi}"
        const val SwipeableCard = "com.github.pseudoankit:SwipeableView:1.0.1"


        const val Pager = "com.google.accompanist:accompanist-pager:0.23.1"
        const val PagerIndicator = "com.google.accompanist:accompanist-pager-indicators:0.23.1"
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

    object Room {
        const val Runtime = "androidx.room:room-runtime:${Versions.Room}"
        const val Compiler = "androidx.room:room-compiler:${Versions.Room}"
        const val Ktx = "androidx.room:room-ktx:${Versions.Room}"
    }

    object Test {
        const val JUnitExt = "androidx.test.ext:junit:1.1.5"
        const val EspressoCore = "androidx.test.espresso:espresso-core:3.5.1"
        const val UiAutomator = "androidx.test.uiautomator:uiautomator:2.2.0"
        const val junit = "junit:junit:4.13.2"
        const val mockk = "io.mockk:mockk:1.13.1"
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.0"
        const val kotlinTests = "org.jetbrains.kotlin:kotlin-test-junit:1.8.21"
        const val turbine = "app.cash.turbine:turbine:0.12.3"
        const val orbitMvi = "org.orbit-mvi:orbit-test:4.3.0"
    }
}
