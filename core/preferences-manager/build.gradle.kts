plugins {
    id(Plugins.AndroidLibrary)
    id(Plugins.Core)
}

android {
    namespace = "pseudoankit.droid.appprefrences"
}

dependencies {
    implementation(libs.datastore)
}