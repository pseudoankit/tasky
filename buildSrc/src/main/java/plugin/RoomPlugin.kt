package plugin

import Plugins
import libs
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
            implementation(project.libs.room.ktx)
            implementation(project.libs.room.runtime)
            ksp(project.libs.room.compiler)
        }
    }
}