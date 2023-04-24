package pseudoankit.droid.tasky.home.presentation.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.swipeablecard.SwipeableCard
import pseudoankit.droid.unify.component.swipeablecard.SwipeableCardConfig

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
                maxOffsetToReveal = 270f,
                revealThreshold = 50f,
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
        modifier = Modifier.matchParentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UnifyIcon(UnifyIconConfig(icon = UnifyIcons.Edit, onClick = onEdit))
        UnifyIcon(UnifyIconConfig(icon = UnifyIcons.Delete, onClick = onDelete))
    }
}