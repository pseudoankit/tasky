plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "pseudoankit.droid.app_shortcuts"
}

dependencies {
    implementation(Dependencies.AndroidX.Core)
    implementation(Dependencies.AndroidX.AppShortcut)

    with(Modules.Core) {
        implementation(project(AgendaManager))
        implementation(project(DesignSystem))
        implementation(project(CoreUi))
    }
}