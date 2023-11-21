package plugin

import Dependencies
import Plugins
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType

class DetektConventionPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    with(project) {
      // Apply detekt plugin to module
      pluginManager.apply(Plugins.Detekt)

      // Configure jvmTarget for gradle task `detekt`
      tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        jvmTarget = JavaVersion.VERSION_17.toString()
      }
      // Configure jvmTarget for gradle task `detektGenerateBaseline`
      tasks.withType<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>().configureEach {
        jvmTarget = JavaVersion.VERSION_17.toString()
      }

      // Configure detekt
      extensions.getByType<DetektExtension>().apply {
        buildUponDefaultConfig = true // preconfigure defaults.
        allRules = false // activate all available (even unstable) rules.
        autoCorrect = false // To enable or disable auto formatting.
        parallel = true // To enable or disable parallel execution of detekt on multiple submodules.
        config.setFrom("config/detekt/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior.
        baseline =
          file("config/detekt/detekt-baseline.xml") // a way of suppressing issues before introducing detekt.
      }

      tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        reports {
          // observe findings in your browser with structure and code snippets
          html.required.set(true)
          // similar to the console output, contains issue signature to manually edit baseline files
          txt.required.set(true)
          // simple Markdown format
          md.required.set(true)
        }
      }

      dependencies.apply {
        // You can add more detektPlugins like shown below.
        add(
          "detektPlugins",
          Dependencies.DeteKt.Compose
        ) // Add this in case you want compose rules with detekt
      }
    }
  }
}
