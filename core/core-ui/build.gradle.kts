plugins {
    id(Plugins.Library.Feature)
    id(Plugins.Library.Compose.Core)
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
    }
}