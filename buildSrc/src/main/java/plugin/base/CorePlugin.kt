package plugin.base

import Dependencies
import Plugins
import Versions
import com.android.build.gradle.BaseExtension
import libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import plugin.util.PluginConstants
import plugin.util.implementation

/**
 * Plugin containing all common code for any gradle
 * It includes defaultConfigs, compileOptions, kotlinOptions and koin deps
 */
open class CorePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply {
            apply("org.jetbrains.kotlin.android")
            apply("kotlinx-serialization")
            apply("kotlin-parcelize")
            apply("org.sonarqube")
            apply(Plugins.Detekt)
        }

        val androidExtension =
            project.extensions.getByName(PluginConstants.ANDROID) as BaseExtension

        androidExtension.apply {
            defaultConfig {
                targetSdk = project.libs.versions.targetSdk.get().toInt()
                minSdk = project.libs.versions.minSdk.get().toInt()
                setCompileSdkVersion(project.libs.versions.compileSdk.get().toInt())
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
                isCoreLibraryDesugaringEnabled = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = Versions.Compose.Compiler
            }

            lintOptions {
                disable += mutableSetOf(
                    "ParcelCreator", "ComposeModifierMissing"
                )
            }
        }

        project.tasks.withType(KotlinCompile::class.java).configureEach {
            kotlinOptions {
                jvmTarget = project.libs.versions.jvmTarget.get()

                // to avoid unncessary annotations
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-opt-in=androidx.compose.ui.ExperimentalComposeUiApi",
                    "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
                    "-opt-in=com.google.accompanist.pager.ExperimentalPagerApi",
                    "-opt-in=com.google.accompanist.permissions.ExperimentalPermissionsApi"
                )

                // generate compose compiler reports : ./gradlew assembleRelease -PenableComposeReports=true --rerun-tasks
                if (project.findProperty("enableComposeReports") == "true") {
                    freeCompilerArgs = freeCompilerArgs + listOf(
                        "-P",
                        "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=${project.buildDir.absolutePath}/compose_metrics"
                    ) + listOf(
                        "-P",
                        "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=${project.buildDir.absolutePath}/compose_metrics"
                    )
                }
            }
        }

        project.dependencies {
            with(Dependencies.Koin) {
                this@dependencies.implementation(Core)
                this@dependencies.implementation(Android)
            }
            with(Dependencies.Kotlin) {
                this@dependencies.implementation(ImmutableCollection)
                this@dependencies.implementation(Serialization)
            }
            with(Dependencies.Compose) {
                this@dependencies.implementation(Runtime)
            }
            add("coreLibraryDesugaring", "com.android.tools:desugar_jdk_libs:1.1.5")
        }
    }
}
