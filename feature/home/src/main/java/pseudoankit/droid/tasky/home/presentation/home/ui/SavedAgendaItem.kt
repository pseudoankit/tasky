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
import pseudoankit.droid.unify.components.card.DraggableCard
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

internal object SavedAgendaItem {
    @Composable
    operator fun invoke(
        agendaItem: AgendaItem,
        onCompletionToggled: () -> Unit,
        onDelete: () -> Unit,
        onEdit: () -> Unit
    ) {
        Box(Modifier.fillMaxWidth()) {
            ActionsItems(
                onDelete = onDelete,
                onEdit = onEdit
            )

            DraggableCard {
                AgendaItemCard(
                    agendaItem = agendaItem,
                    onCompletionToggled = onCompletionToggled,
                )
            }
        }
    }

    @Composable
    private fun ActionsItems(
        onDelete: () -> Unit,
        onEdit: () -> Unit
    ) {
        Row {
            UnifyIcon(UnifyIcon.Config(icon = UnifyIcons.DropDown))
            UnifyIcon(UnifyIcon.Config(icon = UnifyIcons.DropDown))
        }
    }

    @Composable
    private fun AgendaItemCard(
        agendaItem: AgendaItem,
        onCompletionToggled: () -> Unit
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = agendaItem.backgroundColor)
                .padding(
                    bottom = UnifyDimens.Dp_12,
                    start = UnifyDimens.Dp_16,
                    end = UnifyDimens.Dp_16,
                    top = UnifyDimens.Dp_16
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
                        tint = UnifyColors.White
                    )
                )
                UnifyTextView(
                    UnifyTextView.Config(
                        text = agendaItem.title,
                        textType = UnifyTextType.TitleMedium,
                        color = agendaItem.tint,
                        textDecoration = if (agendaItem.completed) TextDecoration.LineThrough else TextDecoration.None,
                        maxLines = 1,
                        modifier = Modifier.offset(x = UnifyDimens.Dp_8)
                    )
                )
            }
            UnifyTextView(
                UnifyTextView.Config(
                    text = "Description.....",
                    textType = UnifyTextType.BodyLarge,
                    color = agendaItem.tint,
                    modifier = Modifier.offset(x = UnifyDimens.Dp_32)
                )
            )
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
}