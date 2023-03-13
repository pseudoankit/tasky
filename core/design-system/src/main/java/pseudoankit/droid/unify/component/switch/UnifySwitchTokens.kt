package pseudoankit.droid.unify.component.switch

import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import pseudoankit.droid.unify.token.UnifyColors

internal object UnifySwitchTokens {

    private val BorderColor = UnifyColors.Transparent

    @Composable
    fun colors(): SwitchColors {
        return SwitchDefaults.colors(
            checkedThumbColor = UnifyColors.Black,
            uncheckedThumbColor = UnifyColors.Black,
            disabledCheckedThumbColor = UnifyColors.Gray100,
            disabledUncheckedThumbColor = UnifyColors.Gray100,
            checkedTrackColor = UnifyColors.Black.copy(alpha = .1f),
            uncheckedTrackColor = UnifyColors.Gray100.copy(alpha = .9f),
//            disabledCheckedTrackColor =,
//            disabledUncheckedTrackColor =,
//            checkedIconColor = ,
//            uncheckedIconColor =,
//            disabledCheckedIconColor =,
//            disabledUncheckedIconColor =,
            checkedBorderColor = BorderColor,
            uncheckedBorderColor = BorderColor,
            disabledCheckedBorderColor = BorderColor,
            disabledUncheckedBorderColor = BorderColor,
        )
    }
}