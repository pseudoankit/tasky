plugins {
    id(Plugins.AndroidLibrary)
    id(Plugins.Core)
    id(Plugins.RoomDatabase)
}

android {
    namespace = "pseudoankit.droid.dbmanager"
}

dependencies {
    implementation(projects.core.agendaManger)
    implementation(projects.core.core)
}