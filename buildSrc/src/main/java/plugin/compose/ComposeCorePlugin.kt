package plugin.compose

import com.android.build.gradle.BaseExtension
import libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import plugin.util.PluginConstants
import plugin.util.implementation
import plugin.util.lintChecks

/**
 * Plugin containing setup for adding compose core deps
 */
open class ComposeCorePlugin : Plugin<Project> {

    override fun apply(project: Project) {

        val androidExtension =
            project.extensions.getByName(PluginConstants.ANDROID) as BaseExtension

        androidExtension.apply {
            buildFeatures.apply {
                compose = true
            }
        }

        project.dependencies {
            implementation(project.libs.bundles.compose)
            implementation(platform(project.libs.compose.bom))
            lintChecks(project.libs.slack.lint.compose)
        }
    }
}
