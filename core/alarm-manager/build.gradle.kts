plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "pseudoankit.droid.alarm_scheduler"
}

dependencies {
    implementation(projects.core.notificationManager)
}