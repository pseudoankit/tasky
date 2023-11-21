plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.0")
    implementation(kotlin("gradle-plugin", "1.8.10"))
    compileOnly("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.21.0")
}

gradlePlugin {
    plugins {
        val plugins = listOf(
            "core-plugin" to "plugin.base.CorePlugin",
            "core-library-feature-plugin" to "plugin.base.CoreLibraryFeaturePlugin",
            "compose-core-plugin" to "plugin.compose.ComposeCorePlugin",
            "compose-feature-plugin" to "plugin.compose.ComposeFeaturePlugin",
            "room-db-plugin" to "plugin.RoomPlugin",
            "ut-plugin" to "plugin.UnitTestPlugin",
            "detekt-plugin" to "plugin.DetektConventionPlugin"
        )

        plugins.forEach {
            register(it.first) {
                id = it.first
                implementationClass = it.second
            }
        }
    }
}