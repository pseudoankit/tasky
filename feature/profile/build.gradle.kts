plugins {
    id(Plugins.Library.Feature)
    id(Plugins.Library.ComposeFeature)
}

// todo create a utility
ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "Profile")
}

android {
    namespace = "pseudoankit.droid.profile"
}
