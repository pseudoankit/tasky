plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeFeatureLib)
}

ksp {
    arg("compose-destinations.mode", "destinations")
    arg("compose-destinations.moduleName", "agenda-reminder")
}

android {
    namespace = "pseudoankit.droid.tasky.reminder"
}

dependencies {
    implementation(projects.core.agendaManger)
}