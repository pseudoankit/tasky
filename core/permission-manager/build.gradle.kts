plugins {
    id(Plugins.Library.Feature)
    id(Plugins.Library.ComposeFeature)
}

android {
    namespace = "com.example.permission_manager"
}

dependencies {
    api("com.google.accompanist:accompanist-permissions:0.26.2-beta")
}