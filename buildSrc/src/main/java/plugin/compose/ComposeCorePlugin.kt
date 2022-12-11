package plugin.compose

import Dependencies
import Versions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import plugin.util.implementation
import plugin.util.libraryExtension

/**
 * Plugin containing setup for adding compose core deps
 * ###Applicable only for library level module
 */
open class ComposeCorePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val libraryExtension = project.libraryExtension

        libraryExtension.apply {
            composeOptions {
                kotlinCompilerExtensionVersion = Versions.Compose.Compiler
            }
            buildFeatures.apply {
                compose = true
            }
        }

        project.dependencies {
            with(Dependencies.Compose) {
                this@dependencies.implementation(Ui)
                this@dependencies.implementation(Runtime)
                this@dependencies.implementation(FoundationLayout)
                this@dependencies.implementation(UiToolingPreview)
                this@dependencies.implementation(UiTooling)
                this@dependencies.implementation(Material3)
            }
        }
    }
}