plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeFeatureLib)
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
    with(Modules.Core) {
        implementation(project(AgendaManager))
        implementation(project(PermissionManager))
    }
}