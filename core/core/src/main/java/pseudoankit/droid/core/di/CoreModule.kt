package pseudoankit.droid.core.di

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import pseudoankit.droid.core.dispatcher.DispatcherProvider
import pseudoankit.droid.core.dispatcher.DispatcherProviderImpl
import pseudoankit.droid.core.notification.TaskyNotifier

object CoreModule {

    operator fun invoke() = module {
        single<DispatcherProvider> { DispatcherProviderImpl() }
        single { TaskyNotifier(androidApplication()) }
    }
}