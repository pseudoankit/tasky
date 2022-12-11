plugins {
    id(Plugins.Library)
}

apply {
    applyCoreLibrary(rootDir)
    applyComposeFeature(rootDir)
}

android {
    namespace = "pseudoankit.droid.navigation"
}

dependencies {
    with(FeatureModules) {
        implementation(project(Authentication))
    }
}