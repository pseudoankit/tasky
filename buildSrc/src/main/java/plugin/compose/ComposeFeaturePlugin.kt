package plugin.compose

import Modules
import libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import plugin.util.implementation
import plugin.util.implementationProject
import plugin.util.kotlinExtension
import plugin.util.ksp
import plugin.util.libraryExtension

/**
 * Plugin containing setup for adding compose core deps with navigation lib setup
 * Also includes coreUi and koin deps
 * ###Applicable only for library level module
 */
class ComposeFeaturePlugin : ComposeCorePlugin() {

    override fun apply(project: Project) {
        project.plugins.apply {
            apply("com.google.devtools.ksp")
        }

        project.libraryExtension?.apply {
            libraryVariants.all {
                project.kotlinExtension.sourceSets.getByName(name) {
                    kotlin.srcDir("build/generated/ksp/$name/kotlin")
                }
            }
        }

        project.dependencies {
            implementation(project.libs.compose.destinations)
            ksp(project.libs.compose.destinations.ksp)
            implementation(project.libs.compose.orbit.mvi)
            implementation(project.libs.koin.compose)

            with(Modules.Core) {
                this@dependencies.implementationProject(DesignSystem)
                this@dependencies.implementationProject(CoreUi)
            }
        }

        super.apply(project)
    }
}