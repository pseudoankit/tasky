object Plugins {

    /**
     * Plugin containing all common code for any gradle
     * It includes defaultConfigs, compileOptions, kotlinOptions and koin deps
     */
    const val Core = "base-plugin"

    object Library {
        /**
         * Plugin containing all common code for library gradle
         * ###Applicable in library modules only
         */
        const val Feature = "base-library-plugin"

        object Compose {
            /**
             * Plugin containing setup for adding compose core deps
             * ###Applicable only for library level module
             */
            const val Core = "compose-core-plugin"

            /**
             * Plugin containing setup for adding compose core deps with navigation lib setup
             * Also includes coreUi and koin deps
             * ###Applicable only for library level module
             */
            const val Feature = "compose-feature-plugin"
        }
    }

    const val AndroidLibrary = "com.android.library"
    const val AndroidApplication = "com.android.application"
    const val Ksp = "com.google.devtools.ksp"
}