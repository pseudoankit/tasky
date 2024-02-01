plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeCore)
}

android {
    namespace = "pseudoankit.droid.app_shortcuts_n_widgets"
}

dependencies {
    implementation(libs.glance.appwidget)
    implementation(libs.glance)
    implementation(libs.androidx.appShortcut)

    with(Modules.Core) {
        implementation(project(AgendaManager))
        implementation(project(DesignSystem))
        implementation(project(CoreUi))
        implementation(project(PreferencesManager))
    }
}