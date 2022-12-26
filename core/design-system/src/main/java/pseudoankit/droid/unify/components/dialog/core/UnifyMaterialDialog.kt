package pseudoankit.droid.unify.components.dialog.core

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogScope
import com.vanpra.composematerialdialogs.MaterialDialogState
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

object UnifyMaterialDialog {

    @Composable
    operator fun invoke(
        state: MaterialDialogState,
        onCloseRequest: (MaterialDialogState) -> Unit,
        content: @Composable MaterialDialogScope.() -> Unit
    ) {
        val onActionButtonClick = remember {
            {
                state.hide()
                onCloseRequest(state)
            }
        }
        val actionButtonTextStyle = remember {
            TextStyle.Default.copy(color = UnifyColors.Black)
        }

        MaterialDialog(
            dialogState = state,
            buttons = {
                positiveButton(
                    "OK",
                    onClick = onActionButtonClick,
                    textStyle = actionButtonTextStyle
                )
                negativeButton(
                    "Cancel",
                    onClick = onActionButtonClick,
                    textStyle = actionButtonTextStyle
                )
            },
            shape = RoundedCornerShape(UnifyDimens.Radius.Large),
            autoDismiss = true,
            onCloseRequest = onCloseRequest,
            content = content
        )
    }
}