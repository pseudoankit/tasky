plugins {
    id(Plugins.CoreFeatureLib)
}

android {
    namespace = "com.pseudoankit.test_helper"
}

dependencies {
    with(Dependencies.Test) {
        testImplementation(mockk)
        testImplementation(junit)
        testImplementation(kotlinTests)
        testImplementation(coroutine)
        testImplementation(orbitMvi)
        testImplementation(turbine)
    }
}