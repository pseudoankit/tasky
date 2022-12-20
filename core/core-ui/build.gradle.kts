plugins {
    id(Plugins.Library)
    id(Plugins.Core)
    id(Plugins.ComposeLibraryCore)
}

android {
    namespace = "pseudoankit.droid.coreui"
}

dependencies {
    with(Modules.Core) {
        implementation(project(DesignSystem))
        implementation(project(Core))
    }
}