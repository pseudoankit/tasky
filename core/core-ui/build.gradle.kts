plugins {
    id(Plugins.Library.Feature)
    id(Plugins.ComposeCore)
}

android {
    namespace = "pseudoankit.droid.coreui"
}

dependencies {
    with(Modules.Core) {
        implementation(project(DesignSystem))
    }

    with(Dependencies.Compose) {
        implementation(ComposeDestinations)
        implementation(OrbitMvi)
    }
}