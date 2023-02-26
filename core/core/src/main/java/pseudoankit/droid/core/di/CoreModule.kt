package pseudoankit.droid.core.di

import org.koin.dsl.module
import pseudoankit.droid.core.dispatcher.DispatcherProvider
import pseudoankit.droid.core.dispatcher.DispatcherProviderImpl

object CoreModule {

    operator fun invoke() = module {
        single<DispatcherProvider> { DispatcherProviderImpl() }
    }
}