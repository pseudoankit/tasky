plugins {
    id(Plugins.CoreLibrary)
    id(Plugins.ComposeLibraryCore)
}

android {
    namespace = "pseudoankit.droid.coreui"
}

dependencies {
    with(Dependencies.Coroutine) {
        implementation(Core)
        implementation(Android)
    }
}
