plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.RoomDatabase)
    id(Plugins.UnitTestPlugin)
}

android {
    namespace = "pseudoankit.droid.agendamanger"
}

dependencies {
    implementation(projects.core.alarmManager)
    implementation(projects.core.notificationManager)
}
