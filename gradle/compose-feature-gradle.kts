apply {
    from("$rootDir${Plugins.ComposeCore}")
}

dependencies {
    implementation(project(CoreModules.CoreUI))
    implementation(project(CoreModules.Navigation))

//    implementation(KoinDeps.ViewModel)
//    implementation(KoinDeps.Compose)

    // implementation(ComposeDeps.ComposeDestinations)
    // implementation(ComposeDeps.ComposeDestinationsKsp)
}