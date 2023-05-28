package pseudoankit.droid.app_widgets.agenda_items

import androidx.annotation.WorkerThread
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.Action
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.itemsIndexed
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import org.koin.java.KoinJavaComponent.inject
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.AgendaRepository
import pseudoankit.droid.app_widgets.util.WidgetDeeplinkProvider
import pseudoankit.droid.core.deeplink.DeepLinkUtil
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.core.util.extension.parseToString
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.utils.UnifyDrawable
import java.time.LocalDate

internal object AgendaItemsAppWidget : GlanceAppWidget() {

    private val agendaRepository: AgendaRepository by inject(AgendaRepository::class.java)
    private val deeplinkProvider: WidgetDeeplinkProvider by inject(WidgetDeeplinkProvider::class.java)

    @WorkerThread
    fun agendaItemsFromToday() = agendaRepository.getAllSavedItem().mapNotNull {
        if (it.date.value < LocalDate.now()) return@mapNotNull null
        it
    }

    @Composable
    override
    fun Content() {

        Column(
            modifier = GlanceModifier.fillMaxSize().background(UnifyColors.Blue200)
        ) {
            Header(
                addAgendaButtonClickIntent = actionStartActivity(
                    intent = DeepLinkUtil.createDeeplinkIntent(TaskyDeeplink.agendaSelection)
                )
            )

            val items = agendaItemsFromToday()

            SavedAgendaItems(items = items)
        }
    }

    @Composable
    private fun SavedAgendaItems(items: List<AgendaItem>) {
        LazyColumn(
            modifier = GlanceModifier.fillMaxSize()
        ) {
            itemsIndexed(items) { index, item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DateChip(
                        currentItem = item,
                        previousItem = items.getOrNull(index - 1)
                    )
                    Row(
                        modifier = GlanceModifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                            .cornerRadius(8.dp)
                            .background(UnifyColors.Blue50)
                            .clickable(
                                onClick = actionStartActivity(
                                    intent = DeepLinkUtil.createDeeplinkIntent(
                                        deeplinkUri = deeplinkProvider.agendaDetailRoute(
                                            item.mapToAgendaTypes
                                        )
                                    )
                                )
                            )
                    ) {
                        Text(
                            text = item.title,
                            style = TextStyle(
                                color = ColorProvider(UnifyColors.Black),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    }
                    Spacer(GlanceModifier.height(4.dp))
                }
            }
        }
    }

    @Composable
    private fun DateChip(currentItem: AgendaItem, previousItem: AgendaItem?) {
        if (currentItem.date != previousItem?.date) {
            Text(
                text = currentItem.date.parseToString("dd MMM").orEmpty(),
                modifier = GlanceModifier
                    .background(UnifyColors.White)
                    .cornerRadius(8.dp)
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                style = TextStyle(

                )
            )
            Spacer(GlanceModifier.height(4.dp))
        }
    }

    @Composable
    private fun Header(
        addAgendaButtonClickIntent: Action
    ) {
        Row(
            modifier = GlanceModifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
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
