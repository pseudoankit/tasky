plugins {
    id(Plugins.Library)
}

apply {
    applyCore(rootDir)
}

android {
    namespace = "pseudoankit.droid.core"
}