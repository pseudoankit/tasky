apply {
    from("$rootDir${Plugins.ComposeCore}")
}

dependencies {
    implementation(project(CoreModules.CoreUI))

    implementation(KoinDeps.Compose)

    // implementation(ComposeDeps.ComposeDestinations)
    // implementation(ComposeDeps.ComposeDestinationsKsp)
}