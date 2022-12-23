package pseudoankit.droid.unify.components.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.components.icon.UnifyIcon
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.switch.UnifySwitch
import pseudoankit.droid.unify.components.textview.UnifyTextType
import pseudoankit.droid.unify.components.textview.UnifyTextView

internal object UnifyListComponents {

    @Composable
    fun Label(label: String, color: Color) {
        UnifyTextView(
            config = UnifyTextView.Config(
                text = label,
                textType = UnifyTextType.BodyLarge,
                color = color,
                maxLines = 1
            )
        )
    }

    @Composable
    fun LeadingIcon(leadingIcon: UnifyIcons?, tint: Color) {
        if (leadingIcon == null) return

        UnifyIcon(config = UnifyIcon.Config(icon = leadingIcon, tint = tint))
    }

    @Composable
    fun TrailingIcon(trailingIcon: UnifyList.TrailingIcon?) = when (trailingIcon) {
        is UnifyList.TrailingIcon.Switch -> {
            UnifySwitch(config = trailingIcon.value)
        }
        null -> {}
    }
}