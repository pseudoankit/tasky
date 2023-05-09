plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.RoomDatabase)
    id(Plugins.UnitTestPlugin)
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
