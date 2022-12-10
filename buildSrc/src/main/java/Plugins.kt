import org.gradle.api.plugins.ObjectConfigurationAction
import java.io.File

object Plugins {
    object App {
        const val Android = "com.android.application"
    }

    const val Ksp = "com.google.devtools.ksp"
    const val Kotlin = "org.jetbrains.kotlin.android"
    const val Library = "com.android.library"
}

fun ObjectConfigurationAction.applyTaskyCore(rootDir: File) = apply {
    from("${rootDir}/gradle/core-gradle.kts")
}

fun ObjectConfigurationAction.applyTaskyLibrary(rootDir: File) = apply {
    from("${rootDir}/gradle/library-gradle.kts")
}

fun ObjectConfigurationAction.applyTaskyCompose(rootDir: File) = apply {
    from("${rootDir}/gradle/compose-gradle.kts")
}