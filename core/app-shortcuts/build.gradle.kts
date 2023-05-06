plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "pseudoankit.droid.app_shortcuts"
}

dependencies {
    implementation(Dependencies.Core.Core)
    implementation(Dependencies.Core.AppShortcut)
    with(Modules.Core) {
        implementation(project(AgendaManager))
        implementation(project(DesignSystem))
    }
}