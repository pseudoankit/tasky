plugins {
    id(Plugins.Library)
    id(Plugins.Core)
    id(Plugins.ComposeLibraryCore)
}

android {
    namespace = "pseudoankit.droid.unify"
}

dependencies {
    with(Dependencies.Compose) {
        implementation(FontAwesome)
        implementation(DatePicker)
    }
}
