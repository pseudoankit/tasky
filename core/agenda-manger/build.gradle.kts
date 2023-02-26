plugins {
    id(Plugins.Library.Feature)
    id(Plugins.RoomDatabase)
}

android {
    namespace = "pseudoankit.droid.agendamanger"
}

dependencies {
    with(Modules.Core) {
        implementation(project(AlarmManager))
        implementation(project(NotificationManager))
    }
}
