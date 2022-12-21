plugins {
    id(Plugins.Library.Feature)
    id(Plugins.Library.Compose.Feature)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "agenda-reminder")
}

android {
    namespace = "pseudoankit.droid.tasky.reminder"
}