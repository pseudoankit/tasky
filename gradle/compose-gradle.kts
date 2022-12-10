android {
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(DependenciesCompose.Ui)
    implementation(DependenciesCompose.Runtime)
    implementation(DependenciesCompose.FoundationLayout)
    implementation(DependenciesCompose.UiToolingPreview)
    implementation(DependenciesCompose.UiTooling)
    implementation(DependenciesCompose.Material3)
    implementation(DependenciesCompose.Activity)
    // implementation(DependenciesCompose.ComposeDestinations)
    // implementation(DependenciesCompose.ComposeDestinationsKsp)
}