plugins.apply(Plugins.Kotlin)

android {
    compileSdk = BuildConfig.CompileSdkVersion

    defaultConfig {
        minSdk = BuildConfig.MinSdkVersion
        targetSdk = BuildConfig.TargetSdkVersion
    }

    compileOptions {
        sourceCompatibility = BuildConfig.JavaVersion
        targetCompatibility = BuildConfig.JavaVersion
    }

    kotlinOptions {
        jvmTarget = BuildConfig.JvmTarget
    }

    // todo check for stability
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.KotlinCompilerVersion
    }
}
