plugins {
    id(Plugins.Library.Feature)
    id(Plugins.Library.ComposeFeature)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "agenda-reminder")
}

android {
    namespace = "pseudoankit.droid.tasky.reminder"
}

dependencies {
    with(Modules.Core) {
        implementation(project(AgendaManager))
    }
}