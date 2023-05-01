plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "pseudoankit.droid.app_shortcuts"
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.Core.Core)
    implementation(Dependencies.Core.AppShortcut)
    with(Modules.Core) {
        implementation(project(DesignSystem))
    }
}