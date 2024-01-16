package pseudoankit.droid.tasky.navigation.di

import org.koin.dsl.module
import pseudoankit.droid.app_widgets.util.WidgetDeeplinkProvider
import pseudoankit.droid.tasky.home.navigator.HomeDeepLinkProvider
import pseudoankit.droid.tasky.navigation.deeplink.DeepLinkProvider
import pseudoankit.droid.tasky.reminder.navigator.ReminderDeepLinkProvider

object NavigationModule {

    operator fun invoke() = module {
        val deepLinkProvider = DeepLinkProvider()
        factory<ReminderDeepLinkProvider> { deepLinkProvider }
        factory<HomeDeepLinkProvider> { deepLinkProvider }
        factory<WidgetDeeplinkProvider> { deepLinkProvider }
    }
}