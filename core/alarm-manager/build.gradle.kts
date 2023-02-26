plugins {
    id(Plugins.Library.Feature)
}

android {
    namespace = "pseudoankit.droid.alarm_scheduler"
}

dependencies {
    with(Modules.Core) {
        implementation(project(NotificationManager))
    }
}