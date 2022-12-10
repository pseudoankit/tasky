android {
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(ComposeDeps.Ui)
    implementation(ComposeDeps.Runtime)
    implementation(ComposeDeps.FoundationLayout)
    implementation(ComposeDeps.UiToolingPreview)
    implementation(ComposeDeps.UiTooling)
    implementation(ComposeDeps.Material3)
    implementation(ComposeDeps.Activity)
}