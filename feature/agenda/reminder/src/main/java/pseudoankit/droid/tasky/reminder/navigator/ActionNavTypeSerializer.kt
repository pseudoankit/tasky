package pseudoankit.droid.tasky.reminder.navigator

import com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer
import com.ramcosta.composedestinations.navargs.NavTypeSerializer
import pseudoankit.droid.agendamanger.domain.model.AgendaTypes

@NavTypeSerializer
object ActionNavTypeSerializer : DestinationsNavTypeSerializer<AgendaTypes.Action> {
    private const val CREATE = 0L

    override fun toRouteString(value: AgendaTypes.Action): String {
        return when (value) {
            AgendaTypes.Action.Create -> "$CREATE"
            is AgendaTypes.Action.Edit -> "${value.id}"
        }
    }

    override fun fromRouteString(routeStr: String): AgendaTypes.Action {
        return when (val id = routeStr.toLongOrNull()) {
            null, CREATE -> AgendaTypes.Action.Create
            else -> AgendaTypes.Action.Edit(id)
        }
    }
}