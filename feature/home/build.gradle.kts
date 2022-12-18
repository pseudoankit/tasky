plugins {
    id(Plugins.CoreLibrary)
    id(Plugins.ComposeLibraryFeature)
}

// todo create a utility
ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "Home")
}

android {
    namespace = "pseudoankit.droid.tasky.home"
}

dependencies {

}