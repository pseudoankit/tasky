package pseudoankit.droid.unify.token

import pseudoankit.droid.unify.components.textview.UnifyTextType

internal object UnifyTokens {
    object Button {
        val Radius = UnifyDimens.Radius.Large
        val Height = UnifyDimens.Dp_58
        val TextType = UnifyTextType.TitleMedium
    }

    object TimePicker {
        val SelectedColor = UnifyColors.Blue200
    }

    object TextField {
        object Icon {
            val Color = UnifyColors.Gray500
            val Size = UnifyDimens.Dp_24
        }
    }

    object CheckBox {
        val BackgroundColor = UnifyColors.Gray100
        val CheckMarkColor = UnifyColors.Black
    }

    object Switch {
        val BorderColor = UnifyColors.Transparent

        object ThumbColor {
            val enabled = UnifyColors.Black
            val disabled = UnifyColors.Gray100
        }

        object TrackColor {
            val enabled = UnifyColors.Black.copy(alpha = .1f)
            val disabled = UnifyColors.Gray100.copy(alpha = .42f)
        }
    }
}