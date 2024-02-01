plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeFeatureLib)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "Authentication")
}

android {
    namespace = "pseudoankit.droid.authentication"
}

dependencies {
    implementation(projects.core.preferencesManager)
}
