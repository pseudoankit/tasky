package pseudoankit.droid.tasky.home.presentation.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaItemsUiMapper.backgroundColor
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaItemsUiMapper.displayDateTime
import pseudoankit.droid.tasky.home.presentation.mapper.AgendaItemsUiMapper.tint
import pseudoankit.droid.unify.components.card.UnifyCard
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

internal object SavedAgendaItem {

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    operator fun invoke(
        agendaItem: AgendaItem,
        onItemCompletionToggled: (AgendaItem) -> Unit,
        onOptionClicked: (AgendaItem) -> Unit
    ) {

        val dismissState = rememberDismissState(
            confirmStateChange = {
                if (it == DismissValue.DismissedToEnd) {

                }
                true
            }
        )

        SwipeToDismiss(
            state = dismissState,
            directions = setOf(DismissDirection.EndToStart),
            background = {

            },
            dismissThresholds = { FractionalThreshold(.2f) }
        ) {
            Content(
                agendaItem,
                onItemCompletionToggled,
                onOptionClicked
            )
        }
    }

    @Composable
    private fun Content(
        agendaItem: AgendaItem,
        onItemCompletionToggled: (AgendaItem) -> Unit,
        onOptionClicked: (AgendaItem) -> Unit
    ) = UnifyCard {
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
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.weight(.93f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    UnifyIcon(
                        UnifyIcon.Config(
                            icon = if (agendaItem.completed) UnifyIcons.Circle else UnifyIcons.CheckCircle,
                            onClick = {
                                onItemCompletionToggled(agendaItem)
                            },
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
                Spacer(modifier = Modifier.weight(.07f))
                UnifyIcon(
                    config = UnifyIcon.Config(
                        icon = UnifyIcons.EllipsisV,
                        tint = UnifyColors.White,
                        onClick = {
                            onOptionClicked(agendaItem)
                        }
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