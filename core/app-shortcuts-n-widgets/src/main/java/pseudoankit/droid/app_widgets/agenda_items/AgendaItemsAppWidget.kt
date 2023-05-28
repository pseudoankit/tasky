package pseudoankit.droid.app_widgets.agenda_items

import androidx.annotation.WorkerThread
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
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
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.text.Text
import org.koin.java.KoinJavaComponent.inject
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.AgendaRepository
import pseudoankit.droid.core.deeplink.DeepLinkUtil
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.utils.UnifyDrawable

internal object AgendaItemsAppWidget : GlanceAppWidget() {

    private val agendaRepository: AgendaRepository by inject(AgendaRepository::class.java)

    @WorkerThread
    fun agendaItems() = agendaRepository.getAllSavedItem()

    @Composable
    override
    fun Content() {

        Column(
            modifier = GlanceModifier.fillMaxSize().background(UnifyColors.White)
        ) {
            Header(
                addAgendaButtonClickIntent = actionStartActivity(
                    intent = DeepLinkUtil.createDeeplinkIntent(TaskyDeeplink.agendaSelection)
                )
            )

            val items = agendaItems()

            SavedAgendaItems(items = items)
        }
    }

    @Composable
    private fun SavedAgendaItems(items: List<AgendaItem>) {
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
