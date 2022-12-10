plugins.apply(Plugins.Library)

apply {
    from("$rootDir${Plugins.Core}")
}

dependencies {
    implementation(project(CoreModules.Core))
}
