plugins {
    id(Plugins.AndroidLibrary)
    id(Plugins.Core)
    id(Plugins.Ksp)
}

android {
    namespace = "pseudoankit.droid.dbmanager"
}

dependencies {
    with(Dependencies.Room) {
        implementation(Ktx)
    }

    with(Modules.Core) {
        implementation(project(AgendaManager))
    }
}