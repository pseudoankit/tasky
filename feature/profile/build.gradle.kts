plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeFeatureLib)
}

// todo create a utility
ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "Profile")
}

android {
    namespace = "pseudoankit.droid.profile"
}
