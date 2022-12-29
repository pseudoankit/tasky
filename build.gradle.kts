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
        classpath(kotlin("serialization", version = Versions.Kotlin))
    }
}

plugins {
    id(Plugins.Ksp) version Versions.Compose.KspPlugin apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri(Dependencies.Gradle.PluginsRepo) }
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}