plugins {
    id(Plugins.CoreFeatureLib)
    id(Plugins.ComposeFeatureLib)
}

android {
    namespace = "com.example.permission_manager"
}

dependencies {
    api("com.google.accompanist:accompanist-permissions:0.26.2-beta")
}