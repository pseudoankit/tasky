plugins {
    id(Plugins.Library.Feature)
    id(Plugins.Library.ComposeFeature)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "Authentication")
}

android {
    namespace = "pseudoankit.droid.authentication"
}

dependencies {
    with(Modules.Core) {
        implementation(project(PreferencesManager))
    }
}
