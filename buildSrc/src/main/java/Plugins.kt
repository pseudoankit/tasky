object Plugins {

    /**
     * Plugin containing all common code for any gradle
     * It includes defaultConfigs, compileOptions, kotlinOptions and koin deps
     */
    const val Core = "base-plugin"

    /**
     * Plugin containing all common code for library gradle
     * ###Applicable in library modules only
     */
    const val CoreLibrary = "base-library-plugin"

    /**
     * Plugin containing setup for adding compose core deps
     * ###Applicable only for library level module
     */
    const val ComposeLibraryCore = "compose-core-plugin"

    /**
     * Plugin containing setup for adding compose core deps with navigation lib setup
     * Also includes coreUi and koin deps
     * ###Applicable only for library level module
     */
    const val ComposeLibraryFeature = "compose-feature-plugin"

    const val Library = "com.android.library"
    const val Application = "com.android.application"
    const val Ksp = "com.google.devtools.ksp"
}