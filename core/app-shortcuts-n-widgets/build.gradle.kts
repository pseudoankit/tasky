plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeCore)
}

android {
    namespace = "pseudoankit.droid.app_shortcuts_n_widgets"
}

dependencies {
    with(Dependencies.AndroidX) {
        implementation(GlanceAppWidget)
        implementation(Glance)
        implementation(AppShortcut)
    }

    with(Modules.Core) {
        implementation(project(AgendaManager))
        implementation(project(DesignSystem))
        implementation(project(CoreUi))
        implementation(project(PreferencesManager))
    }
}