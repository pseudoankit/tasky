plugins {
    id(Plugins.Library)
    id(Plugins.Core)
    id(Plugins.ComposeLibraryCore)
}

android {
    namespace = "pseudoankit.droid.core"
}

dependencies {
    with(Modules.Core) {
        implementation(project(DesignSystem))
    }
}