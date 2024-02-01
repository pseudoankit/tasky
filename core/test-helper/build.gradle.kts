plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "com.pseudoankit.test_helper"
}

dependencies {
    implementation(libs.bundles.test)
}