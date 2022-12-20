package pseudoankit.droid.coreui.components.button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import pseudoankit.droid.coreui.token.UnifyColors

internal object UnifyButtonMapper {

    val UnifyButton.State.isDisabled get() = this == UnifyButton.State.Disabled
    val UnifyButton.State.isLoading get() = this == UnifyButton.State.Loading
    val UnifyButton.State.isEnabled get() = this == UnifyButton.State.Enabled

    @Composable
    fun UnifyButton.State.buttonColors() = when (this) {
        UnifyButton.State.Loading -> ButtonDefaults.buttonColors(
            containerColor = UnifyColors.Black,
            contentColor = UnifyColors.White
        )
        UnifyButton.State.Enabled -> ButtonDefaults.buttonColors(
            containerColor = UnifyColors.Black,
            contentColor = UnifyColors.White
        )
        UnifyButton.State.Disabled -> ButtonDefaults.buttonColors(
            containerColor = UnifyColors.Gray,
            contentColor = UnifyColors.DarkGray
        )
    }
}