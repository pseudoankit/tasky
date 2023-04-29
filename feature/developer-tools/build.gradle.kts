plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "pseudoankit.tasky.developer_tools"
}

dependencies {
    debugImplementation(Dependencies.LeakCanary)
}