plugins {
    id(Plugins.Library)
    id(Plugins.Core)
    id(Plugins.ComposeLibraryCore)
}

android {
    namespace = "pseudoankit.droid.coreui"
}

dependencies {
    implementation("com.github.pseudoankit:ComposeFontAwesomeLibrary:v1.2.0")
}
