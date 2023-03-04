package pseudoankit.droid.unify.component.list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIconConfig
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.switch.UnifySwitch
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyDimens

internal object UnifyListComponents {

    @Composable
    fun Label(label: String, color: Color, modifier: Modifier = Modifier) {
        UnifyTextView(
            config = UnifyTextViewConfig(
                text = label,
                textType = UnifyTextType.BodyLarge,
                color = color,
                maxLines = 1,
                modifier = modifier
            )
        )
    }

    @Composable
    fun LeadingIcon(leadingIcon: UnifyIcons?, tint: Color) {
        if (leadingIcon == null) return

        UnifyIcon(config = UnifyIconConfig(icon = leadingIcon, tint = tint))
        Spacer(modifier = Modifier.width(UnifyDimens.Dp_16))
    }

    @Composable
    fun TrailingIcon(trailingIcon: UnifyListItemConfig.TrailingSection?, color: Color) =
        when (trailingIcon) {
            is UnifyListItemConfig.TrailingSection.Switch -> {
                UnifySwitch(config = trailingIcon.value)
            }
            is UnifyListItemConfig.TrailingSection.NoAction -> UnifyIcon(
                config = UnifyIconConfig(
                    tint = color,
                    icon = trailingIcon.value
                )
            )
            null -> {}
        }
}