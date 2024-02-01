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

    implementation(projects.core.agendaManger)
    implementation(projects.core.designSystem)
    implementation(projects.core.coreUi)
    implementation(projects.core.preferencesManager)
}