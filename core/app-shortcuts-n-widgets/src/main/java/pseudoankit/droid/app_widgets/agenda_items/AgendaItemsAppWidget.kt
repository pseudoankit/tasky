package pseudoankit.droid.app_widgets.agenda_items

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.Preferences
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.Action
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.items
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.Text
import kotlinx.serialization.decodeFromString
import pseudoankit.droid.app_widgets.util.WidgetPrefsKey
import pseudoankit.droid.core.deeplink.DeepLinkUtil
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.core.logger.TaskyLogger
import pseudoankit.droid.core.util.defaultJsonSerializer
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.utils.UnifyDrawable

object AgendaItemsAppWidget : GlanceAppWidget() {

    override val stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition

    @Composable
    override
    fun Content() {
        val prefs = currentState<Preferences>()
        val itemsJson = prefs[WidgetPrefsKey.agendaItems].orEmpty()

        val items = try {
            defaultJsonSerializer.decodeFromString<List<WidgetAgendaItem>>(itemsJson)
        } catch (ex: Exception) {
            TaskyLogger.error("error occurred while decoding agenda items, $ex")
            emptyList()
        }

        Column(
            modifier = GlanceModifier.fillMaxSize().background(UnifyColors.White)
        ) {
            Header(
                addAgendaButtonClickIntent = actionStartActivity(
                    intent = DeepLinkUtil.createDeeplinkIntent(TaskyDeeplink.agendaSelection)
                )
            )

            SavedAgendaItems(items = items)
        }
    }

    @Composable
    private fun SavedAgendaItems(items: List<WidgetAgendaItem>) {
        LazyColumn(
            modifier = GlanceModifier.fillMaxSize()
        ) {
            items(items) {
                Text(text = it.title)
            }
        }
    }

    @Composable
    private fun Header(
        addAgendaButtonClickIntent: Action
    ) {
        Row(
            modifier = GlanceModifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .background(UnifyColors.Blue200),
            horizontalAlignment = Alignment.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                provider = ImageProvider(
                    resId = UnifyDrawable.ic_add
                ),
                modifier = GlanceModifier
                    .clickable(
                        onClick = addAgendaButtonClickIntent
                    ),
                contentDescription = ""
            )
        }
    }
}
