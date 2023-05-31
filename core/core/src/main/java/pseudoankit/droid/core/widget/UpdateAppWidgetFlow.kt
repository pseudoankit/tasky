package pseudoankit.droid.core.widget

import kotlinx.coroutines.flow.MutableSharedFlow
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope

/*
 * flow to update app widgets in home screen
 */

typealias UpdateAppWidgetFlow = MutableSharedFlow<Unit>

val UpdateAppWidgetFlowNamed = named("widget")

val Scope.UpdateAppWidgetFlowInstance get() = get<UpdateAppWidgetFlow>(UpdateAppWidgetFlowNamed)