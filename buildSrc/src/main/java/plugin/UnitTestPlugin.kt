package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import plugin.util.testImplementation
import plugin.util.testImplementationProject


class UnitTestPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        project.dependencies {
            with(Dependencies.Test) {
                testImplementation(mockk)
                testImplementation(junit)
                testImplementation(kotlinTests)
                testImplementation(coroutine)
                testImplementation(orbitMvi)
                testImplementation(turbine)
                testImplementationProject(Modules.Core.TestHelper)
            }
        }
    }
}