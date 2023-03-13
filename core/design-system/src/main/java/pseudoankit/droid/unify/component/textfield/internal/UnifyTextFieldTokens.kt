package pseudoankit.droid.unify.component.textfield.internal

import androidx.compose.foundation.shape.RoundedCornerShape
import pseudoankit.droid.unify.component.textfield.UnifyTextFieldConfig
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

internal object UnifyTextFieldTokens {
    object Icon {
        val Color = UnifyColors.Gray500
        val Size = UnifyDimens.Dp_24
    }

    object Background {
        fun shape(type: UnifyTextFieldConfig.Type) = when(type) {
            UnifyTextFieldConfig.Type.Outlined -> RoundedCornerShape(UnifyDimens.Radius.Small)
        }
    }
}