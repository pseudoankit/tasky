buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven { url = uri(Dependencies.Gradle.PluginsRepo) }
    }
    dependencies {
        classpath(Dependencies.Gradle.AndroidTools)
        classpath(Dependencies.Gradle.KotlinGradle)
    }
}

plugins {
    id(Plugins.Ksp) version Versions.Compose.KspPlugin apply true
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri(Dependencies.Gradle.PluginsRepo) }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}