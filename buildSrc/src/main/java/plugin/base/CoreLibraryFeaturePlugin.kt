package plugin.base

import Dependencies
import Modules
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import plugin.util.implementation
import plugin.util.implementationProject

/**
 * Plugin containing all common code for library gradle
 * ###Applicable in library modules only
 */
class CoreLibraryFeaturePlugin : CorePlugin() {
    override fun apply(project: Project) {
        project.plugins.apply {
            apply("com.android.library")
        }

        project.dependencies {
            with(Modules.Core) {
                this@dependencies.implementationProject(Core)
            }
            this@dependencies.implementation(Dependencies.Compose.OrbitMvi)
        }

        super.apply(project)
    }
}