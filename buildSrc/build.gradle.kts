plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
}

dependencies {
    implementation(libs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)

    // Make version catalog available in precompiled scripts
    // https://github.com/gradle/gradle/issues/15383#issuecomment-1567461389
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        val plugins = listOf(
            "core-plugin" to "plugin.base.CorePlugin",
            "core-library-feature-plugin" to "plugin.base.CoreLibraryFeaturePlugin",
            "compose-core-plugin" to "plugin.compose.ComposeCorePlugin",
            "compose-feature-plugin" to "plugin.compose.ComposeFeaturePlugin",
            "room-db-plugin" to "plugin.RoomPlugin",
            "ut-plugin" to "plugin.UnitTestPlugin"
        )

        plugins.forEach {
            register(it.first) {
                id = it.first
                implementationClass = it.second
            }
        }
    }
}