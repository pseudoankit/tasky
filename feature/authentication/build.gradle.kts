plugins {
    id(Plugins.Library.Feature)
    id(Plugins.Library.Compose.Feature)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "Authentication")
}

android {
    namespace = "pseudoankit.droid.authentication"
}
