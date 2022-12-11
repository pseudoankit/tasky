package plugin.base

import BuildConfig
import Dependencies
import com.android.build.gradle.BaseExtension
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
open class BasePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply {
            apply("org.jetbrains.kotlin.android")
        }

        val androidExtension =
            project.extensions.getByName(PluginConstants.ANDROID) as BaseExtension

        androidExtension.apply {
            defaultConfig {
                targetSdk = BuildConfig.TargetSdkVersion
                minSdk = BuildConfig.MinSdkVersion
                setCompileSdkVersion(BuildConfig.CompileSdkVersion)
            }

            compileOptions {
                sourceCompatibility = BuildConfig.JavaVersion
                targetCompatibility = BuildConfig.JavaVersion
            }

            // todo compose compiler later
            project.tasks.withType<KotlinCompile>(KotlinCompile::class.java).configureEach {
                kotlinOptions {
                    jvmTarget = BuildConfig.JvmTarget
                }
            }
        }

        project.dependencies {
            with(Dependencies.Koin) {
                this@dependencies.implementation(Core)
                this@dependencies.implementation(Android)
            }
        }
    }
}
