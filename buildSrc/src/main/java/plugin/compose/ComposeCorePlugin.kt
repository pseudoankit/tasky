package plugin.compose

import Dependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import plugin.util.implementation

/**
 * Plugin containing setup for adding compose core deps
 */
open class ComposeCorePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.dependencies {
            with(Dependencies.Compose) {
                this@dependencies.implementation(Ui)
                this@dependencies.implementation(Runtime)
                this@dependencies.implementation(FoundationLayout)
                this@dependencies.implementation(UiToolingPreview)
                this@dependencies.implementation(UiTooling)
                this@dependencies.implementation(Material3)
                this@dependencies.implementation(Activity)
            }
        }
    }
}