package pseudoankit.droid.tasky.home.presentation.home.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.unify.component.draggablecard.SwipeableCard
import pseudoankit.droid.unify.component.draggablecard.SwipeableCardConfig
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons

@Composable
internal fun SavedAgendaItem(
    agendaItem: AgendaItem,
    onCompletionToggled: () -> Unit,
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    Box(Modifier.wrapContentSize()) {
        ActionsItems(
            onDelete = onDelete,
            onEdit = onEdit
        )

        SwipeableCard(
            SwipeableCardConfig(
                maxOffsetToReveal = 200f,
                revealThreshold = 60f,
                direction = SwipeableCardConfig.Direction.LTR
            )
        ) {
            when (agendaItem) {
                is AgendaItem.Event -> TODO()
                is AgendaItem.Reminder -> AgendaReminderCard(
                    agendaItem = agendaItem,
                    onCompletionToggled = onCompletionToggled,
                )
                is AgendaItem.Task -> TODO()
            }
        }
    }
}

@Composable
private fun BoxScope.ActionsItems(
    onDelete: () -> Unit,
    onEdit: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.matchParentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UnifyIcon(UnifyIconConfig(icon = UnifyIcons.Edit, onClick = onEdit))
        UnifyIcon(UnifyIconConfig(icon = UnifyIcons.Delete, onClick = onDelete))
    }
}