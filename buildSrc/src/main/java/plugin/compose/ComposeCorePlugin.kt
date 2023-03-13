package plugin.compose

import Dependencies
import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import plugin.util.PluginConstants
import plugin.util.implementation

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
            with(Dependencies.Compose) {
                this@dependencies.implementation(Ui)
                this@dependencies.implementation(Runtime)
                this@dependencies.implementation(FoundationLayout)
                this@dependencies.implementation(UiToolingPreview)
                this@dependencies.implementation(UiTooling)
                this@dependencies.implementation(Material3)
                this@dependencies.implementation(Activity)
                this@dependencies.implementation(platform(Bom))
            }
            add("lintChecks", "com.slack.lint.compose:compose-lint-checks:1.1.1")
        }
    }
}
