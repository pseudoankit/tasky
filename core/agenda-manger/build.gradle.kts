plugins {
    id(Plugins.Library.Feature)
    id(Plugins.Ksp)
}

android {
    namespace = "pseudoankit.droid.agendamanger"
}

dependencies {
    with(Dependencies.Room) {
        implementation(Ktx)
        implementation(Runtime)
        ksp(Compiler)
    }
}