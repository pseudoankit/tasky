plugins {
    id(Plugins.Library.Feature)
}

android {
    namespace = "pseudoankit.droid.notification_manager"
}

dependencies {
    implementation(project(Modules.Core.DesignSystem))
}