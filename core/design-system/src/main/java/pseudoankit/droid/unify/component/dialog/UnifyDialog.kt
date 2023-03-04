package pseudoankit.droid.unify.component.dialog

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogScope
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

@Composable
fun UnifyDialog(
    state: UnifyDialogState,
    showActionButton: Boolean = true,
    content: @Composable MaterialDialogScope.() -> Unit
) {
    val materialPickerState = rememberMaterialDialogState()
    when (state.showing) {
        true -> materialPickerState.show()
        false -> materialPickerState.hide()
    }

    val onActionButtonClick = remember {
        {
            state.hide()
        }
    }
    val actionButtonTextStyle = remember {
        TextStyle.Default.copy(color = UnifyColors.Black)
    }

    MaterialDialog(
        dialogState = materialPickerState,
        buttons = {
            if (showActionButton.not()) return@MaterialDialog
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
        onCloseRequest = {
            state.hide()
        },
        content = content
    )
}
