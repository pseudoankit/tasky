package pseudoankit.droid.tasky.home.presentation.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaItemsUiMapper.backgroundColor
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaItemsUiMapper.displayDateTime
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaItemsUiMapper.tint
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

@Composable
internal fun AgendaReminderCard(
    agendaItem: AgendaItem.Reminder,
    onCompletionToggled: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = agendaItem.backgroundColor)
            .padding(
                horizontal = UnifyDimens.Dp_8, vertical = UnifyDimens.Dp_6,
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            UnifyIcon(
                UnifyIcon.Config(
                    icon = if (agendaItem.completed) UnifyIcons.CheckCircle else UnifyIcons.Circle,
                    onClick = onCompletionToggled,
                    tint = UnifyColors.White,
                    size = UnifyDimens.Dp_20
                )
            )
            UnifyTextView(
                UnifyTextView.Config(
                    text = agendaItem.title,
                    textType = UnifyTextType.TitleMedium,
                    color = agendaItem.tint,
                    textDecoration = if (agendaItem.completed) TextDecoration.LineThrough else TextDecoration.None,
                    maxLines = 2,
                    modifier = Modifier.offset(x = UnifyDimens.Dp_8)
                )
            )
        }
        UnifyTextView(
            UnifyTextView.Config(
                text = agendaItem.displayDateTime,
                textType = UnifyTextType.BodySmall,
                color = agendaItem.tint,
                modifier = Modifier.align(Alignment.End)
            )
        )
    }
}