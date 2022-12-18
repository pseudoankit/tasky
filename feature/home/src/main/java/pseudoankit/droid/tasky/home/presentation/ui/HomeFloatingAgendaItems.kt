package pseudoankit.droid.tasky.home.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import pseudoankit.droid.coreui.components.fab.UnifyFloatingButton
import pseudoankit.droid.coreui.components.icon.UnifyIcon
import pseudoankit.droid.coreui.components.text.UnifyTextType
import pseudoankit.droid.coreui.components.text.UnifyTextView
import pseudoankit.droid.coreui.token.UnifyColors
import pseudoankit.droid.coreui.token.UnifyDimens
import pseudoankit.droid.coreui.util.extension.noRippleClickable
import pseudoankit.droid.tasky.home.domain.model.AgendaType

internal object HomeFloatingAgendaItems {

    @Composable
    operator fun invoke(
        onAgendaSelected: (AgendaType) -> Unit,
        onDismiss: () -> Unit,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .noRippleClickable(onDismiss)
                .padding(UnifyDimens.ScreenPadding),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            AgendaType.values().map {
                Spacer(modifier = Modifier.height(UnifyDimens.Dp_8))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    UnifyTextView(
                        config = UnifyTextView.Config(
                            text = it.label.asString(),
                            textType = UnifyTextType.LabelLarge,
                            color = UnifyColors.White
                        )
                    )
                    Spacer(modifier = Modifier.width(UnifyDimens.Dp_4))
                    UnifyFloatingButton(
                        iconConfig = UnifyIcon.Config(icon = it.icon),
                        onClick = {
                            onAgendaSelected(it)
                        }
                    )
                }
            }
        }
    }
}