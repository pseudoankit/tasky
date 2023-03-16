plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "pseudoankit.droid.alarm_scheduler"
}

dependencies {
    with(Modules.Core) {
        implementation(project(NotificationManager))
    }
}