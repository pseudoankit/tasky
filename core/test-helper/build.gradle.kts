plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "com.pseudoankit.test_helper"
}

dependencies {
    with(Dependencies.Test) {
        implementation(mockk)
        implementation(junit)
        implementation(kotlinTests)
        implementation(coroutine)
        implementation(orbitMvi)
        implementation(turbine)
    }
}