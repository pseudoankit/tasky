plugins {
    id(Plugins.CoreLibrary)
    id(Plugins.ComposeLibraryFeature)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "Authentication")
}

android {
    namespace = "pseudoankit.droid.authentication"
}
