plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeFeatureLib)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "agenda-task")
}

android {
    namespace = "pseudoankit.droid.tasky.event"
}