plugins {
    id(Plugins.AndroidLibrary)
    id(Plugins.Core)
    id(Plugins.ComposeCore)
}

android {
    namespace = "pseudoankit.droid.unify"
}

dependencies {
    with(Dependencies.Compose) {
        implementation(FontAwesome)
        implementation(DatePicker)
        implementation(Pager)
        implementation(PagerIndicator)
        implementation(PlaceHolder)
    }
}
