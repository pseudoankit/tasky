plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeCore)
}

android {
    namespace = "pseudoankit.droid.coreui"
}

dependencies {
    implementation(projects.core.designSystem)
    implementation(libs.compose.destinations)
    implementation(libs.compose.orbit.mvi)
}