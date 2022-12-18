plugins {
    id(Plugins.CoreLibrary)
    id(Plugins.ComposeLibraryFeature)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "Home")
}

android {
    namespace = "pseudoankit.droid.tasky.home"
}

dependencies {}