package plugin.util

import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal val Project.kotlinExtension
    get() = (this as ExtensionAware).extensions.getByName(PluginConstants.KOTLIN) as KotlinAndroidProjectExtension

internal val Project.libraryExtension
    get() = project.extensions.getByName(PluginConstants.ANDROID) as? LibraryExtension

internal val Project.appExtension
    get() = project.extensions.getByName(PluginConstants.ANDROID) as? AppExtension

internal fun DependencyHandlerScope.implementation(dependency: Any) {
    add(PluginConstants.IMPLEMENTATION, dependency)
}

internal fun DependencyHandlerScope.lintChecks(dependency: Any) {
    add(PluginConstants.IMPLEMENTATION, dependency)
}

internal fun DependencyHandlerScope.testImplementation(dependencyNotation: Any): Dependency? =
    add(PluginConstants.TEST_IMPLEMENTATION, dependencyNotation)

internal fun DependencyHandlerScope.testImplementationProject(dependency: String) {
    add(
        PluginConstants.TEST_IMPLEMENTATION,
        project(mapOf(PluginConstants.PATH to dependency))
    )
}

internal fun DependencyHandlerScope.implementationProject(dependency: String) {
    add(
        PluginConstants.IMPLEMENTATION,
        project(mapOf(PluginConstants.PATH to dependency))
    )
}

internal fun DependencyHandlerScope.ksp(dependency: Any) {
    add(PluginConstants.KSP, dependency)
}