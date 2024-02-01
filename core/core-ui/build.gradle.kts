plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeCore)
}

android {
    namespace = "pseudoankit.droid.coreui"
}

dependencies {
    with(Modules.Core) {
        implementation(project(DesignSystem))
    }

    implementation(libs.compose.destinations)
    implementation(libs.compose.orbit.mvi)
}