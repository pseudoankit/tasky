package pseudoankit.droid.notification_manager.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import pseudoankit.droid.core.koin.BaseKoinModule
import pseudoankit.droid.notification_manager.TaskyNotifier

object NotifierModule {

    operator fun invoke() = module {
        single { TaskyNotifier(androidApplication()) }
    }
}