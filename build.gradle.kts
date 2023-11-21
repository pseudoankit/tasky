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
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.7.1")
    }
}

plugins {
    id(Plugins.Ksp) version Versions.Compose.KspPlugin apply false
    id(Plugins.Detekt) version Versions.Detekt
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