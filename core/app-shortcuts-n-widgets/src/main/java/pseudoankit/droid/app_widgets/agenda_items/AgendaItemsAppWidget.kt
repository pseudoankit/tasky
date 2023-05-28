package pseudoankit.droid.app_widgets.agenda_items

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import pseudoankit.droid.core.deeplink.DeepLinkUtil
import pseudoankit.droid.core.deeplink.TaskyDeeplink
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.utils.UnifyDrawable

object AgendaItemsAppWidget : GlanceAppWidget() {

    @Composable
    override fun Content() {
        Column(
            modifier = GlanceModifier.fillMaxSize()
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
                            onClick = actionStartActivity(
                                intent = DeepLinkUtil.createDeeplinkIntent(TaskyDeeplink.agendaSelection)
                            )
                        ),
                    contentDescription = ""
                )
            }
        }
    }

}
