package plugin

import Dependencies
import Plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import plugin.util.implementation
import plugin.util.ksp

class RoomPlugin : Plugin<Project> {

    override fun apply(project: Project) {

        project.plugins.apply {
            apply(Plugins.Ksp)
        }

        project.dependencies {
            with(Dependencies.Room) {
                implementation(Ktx)
                implementation(Runtime)
                ksp(Compiler)
            }
        }
    }
}