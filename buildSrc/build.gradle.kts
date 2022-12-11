plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.2.1")
    implementation(kotlin("gradle-plugin", "1.7.0"))
}

gradlePlugin {
    plugins {
        val base = "base-plugin" to "plugin.base.BasePlugin"
        val baseLib = "base-library-plugin" to "plugin.base.BaseLibraryPlugin"
        val composeCoreLib = "compose-core-plugin" to "plugin.compose.ComposeCorePlugin"
        val composeFeatureLib = "compose-feature-plugin" to "plugin.compose.ComposeFeaturePlugin"

        register(base.first) {
            id = base.first
            implementationClass = base.second
        }
        register(baseLib.first) {
            id = baseLib.first
            implementationClass = baseLib.second
        }
        register(composeCoreLib.first) {
            id = composeCoreLib.first
            implementationClass = composeCoreLib.second
        }
        register(composeFeatureLib.first) {
            id = composeFeatureLib.first
            implementationClass = composeFeatureLib.second
        }
    }
}