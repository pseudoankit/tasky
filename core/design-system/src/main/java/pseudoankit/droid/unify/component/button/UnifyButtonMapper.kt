package pseudoankit.droid.unify.component.button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import pseudoankit.droid.unify.token.UnifyColors

internal object UnifyButtonMapper {

    val UnifyButtonConfig.State.isDisabled get() = this == UnifyButtonConfig.State.Disabled
    val UnifyButtonConfig.State.isLoading get() = this == UnifyButtonConfig.State.Loading
    val UnifyButtonConfig.State.isEnabled get() = this == UnifyButtonConfig.State.Enabled

    @Composable
    fun UnifyButtonConfig.State.buttonColors() = when (this) {
        UnifyButtonConfig.State.Loading -> ButtonDefaults.buttonColors(
            containerColor = UnifyColors.Black,
            contentColor = UnifyColors.White
        )
        UnifyButtonConfig.State.Enabled -> ButtonDefaults.buttonColors(
            containerColor = UnifyColors.Black,
            contentColor = UnifyColors.White
        )
        UnifyButtonConfig.State.Disabled -> ButtonDefaults.buttonColors(
            containerColor = UnifyColors.Gray400,
            contentColor = UnifyColors.Gray800
        )
    }
}