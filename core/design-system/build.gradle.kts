plugins {
    id(Plugins.AndroidLibrary)
    id(Plugins.Core)
    id(Plugins.ComposeCore)
}

android {
    namespace = "pseudoankit.droid.unify"
}

dependencies {
    implementation(libs.compose.fontawesome)
    implementation(libs.compose.datepicker)
    implementation(libs.compose.placeholder)
    implementation(libs.compose.swipe)
}
