object Plugins {

    /**
     * Plugin containing all common code for any gradle
     * It includes defaultConfigs, compileOptions, kotlinOptions and koin deps
     * Serialization, Parcelable,
     * ### Every module should atleast include this plugin
     */
    const val Core = "core-plugin"

    /**
     * Plugin containing [com.android.library] plugin, core module along with [Plugins.Core] features internally
     * ###Applicable in library modules only
     */
    const val CoreFeatureLib = "core-library-feature-plugin"

    /**
     * Plugin containing setup for enabling compose at module where applied along with compose core deps
     */
    const val ComposeCore = "compose-core-plugin"

    /**
     * Plugin containing setup for adding compose core [Plugins.ComposeCore] deps with navigation library setup
     * It also includes coreUi, koin deps, design-system orbit MVI deps
     * Mainly this is intented to use at feature module
     * ###Applicable only for library level module
     */
    const val ComposeFeatureLib = "compose-feature-plugin"

    /**
     * Plugin containing setup to enable room db
     */
    const val RoomDatabase = "room-db-plugin"

    /** Plugin containing setup to add unit test in a module */
    const val UnitTestPlugin = "ut-plugin"

    const val AndroidLibrary = "com.android.library"
    const val Ksp = "com.google.devtools.ksp"
    const val Detekt = "io.gitlab.arturbosch.detekt"
}