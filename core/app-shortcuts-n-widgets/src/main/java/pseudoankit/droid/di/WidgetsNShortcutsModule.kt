package pseudoankit.droid.di

import kotlinx.coroutines.flow.MutableSharedFlow
import org.koin.dsl.module
import pseudoankit.droid.core.widget.UpdateAppWidgetFlow
import pseudoankit.droid.core.widget.UpdateAppWidgetFlowNamed

object WidgetsNShortcutsModule {
    operator fun invoke() = module {
        single<UpdateAppWidgetFlow>(UpdateAppWidgetFlowNamed) { MutableSharedFlow() }
    }
}