object BuildConfig {
    const val CompileSdkVersion = 33
    const val JvmTarget = "17"
    const val MinSdkVersion = 23
    const val TargetSdkVersion = CompileSdkVersion
    val JavaVersion = org.gradle.api.JavaVersion.VERSION_17

    object App {
        const val ApplicationId = "pseudoankit.droid.tasky"
        const val VersionCode = 1
        const val VersionName = "1.0"
        const val ProGuardRules = "proguard-rules.pro"
        const val DefaultProguardOptimizeFile = "proguard-android-optimize.txt"
        const val DefaultConsumerProguardFiles = "consumer-rules.pro"
        const val TestInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
