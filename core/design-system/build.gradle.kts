plugins {
    id(Plugins.AndroidLibrary)
    id(Plugins.Core)
    id(Plugins.Library.Compose.Core)
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
