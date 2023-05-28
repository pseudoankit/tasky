plugins {
    id(Plugins.AndroidLibrary)
    id(Plugins.Core)
    id(Plugins.RoomDatabase)
}

android {
    namespace = "pseudoankit.droid.dbmanager"
}

dependencies {
    with(Modules.Core) {
        implementation(project(AgendaManager))
        implementation(project(Core))
    }
}