plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "pseudoankit.droid.notification_manager"
}

dependencies {
    implementation(projects.core.designSystem)
}