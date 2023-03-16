plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "pseudoankit.droid.app_shortcuts"
}

dependencies {
    implementation("androidx.core:core:1.9.0")
    implementation("androidx.core:core-google-shortcuts:1.1.0")
    with(Modules.Core) {
        implementation(project(DesignSystem))
    }
}