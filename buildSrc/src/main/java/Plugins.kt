import org.gradle.api.plugins.ObjectConfigurationAction
import java.io.File

object Plugins {
    object App {
        const val Android = "com.android.application"
    }

    const val Ksp = "com.google.devtools.ksp"
    const val Kotlin = "org.jetbrains.kotlin.android"
    const val Library = "com.android.library"

    const val Core = "/gradle/core-gradle.kts"
    const val CoreLibrary = "/gradle/core-library-gradle.kts"
    const val ComposeCore = "/gradle/compose-core-gradle.kts"
    const val ComposeFeature = "/gradle/compose-feature-gradle.kts"
}

fun ObjectConfigurationAction.applyCore(rootDir: File) = apply {
    from("${rootDir}${Plugins.Core}")
}

fun ObjectConfigurationAction.applyCoreLibrary(rootDir: File) = apply {
    from("${rootDir}${Plugins.CoreLibrary}")
}

fun ObjectConfigurationAction.applyComposeCore(rootDir: File) = apply {
    from("${rootDir}${Plugins.ComposeCore}")
}

fun ObjectConfigurationAction.applyComposeFeature(rootDir: File) = apply {
    from("${rootDir}${Plugins.ComposeFeature}")
}