object DependenciesGradle {
    const val Kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin}"
    const val Android = "com.android.tools.build:gradle:7.2.0"
}

object DependenciesCompose {
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
        "io.github.raamcosta.compose-destinations:core:${Versions.Compose.Destinations}"
    const val ComposeDestinationsKsp =
        "io.github.raamcosta.compose-destinations:ksp:${Versions.Compose.Destinations}"
    const val ConstraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.Compose.ConstraintLayout}"
}