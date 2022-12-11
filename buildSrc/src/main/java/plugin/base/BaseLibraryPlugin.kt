package plugin.base

import Modules
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import plugin.util.implementationProject

/**
 * Plugin containing all common code for library gradle
 * ###Applicable in library modules only
 * It includes defaultConfigs, compileOptions and kotlinOptions
 */
class BaseLibraryPlugin : BasePlugin() {
    override fun apply(project: Project) {
        project.plugins.apply {
            apply("com.android.library")
        }

        project.dependencies {
            with(Modules.Core) {
                this@dependencies.implementationProject(Core)
            }
        }

        super.apply(project)
    }
}