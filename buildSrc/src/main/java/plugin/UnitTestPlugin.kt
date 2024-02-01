package plugin

import Modules
import libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import plugin.util.testImplementation
import plugin.util.testImplementationProject


class UnitTestPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        project.dependencies {
            testImplementation(project.libs.bundles.test)
            testImplementationProject(Modules.Core.TestHelper)
        }
    }
}