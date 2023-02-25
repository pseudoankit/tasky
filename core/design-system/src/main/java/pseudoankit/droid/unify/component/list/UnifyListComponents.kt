package pseudoankit.droid.unify.component.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.component.icon.UnifyIcon
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.switch.UnifySwitch
import pseudoankit.droid.unify.component.textview.UnifyTextType
import pseudoankit.droid.unify.component.textview.UnifyTextView

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
    fun TrailingIcon(trailingIcon: UnifyList.TrailingIcon?, color: Color) = when (trailingIcon) {
        is UnifyList.TrailingIcon.Switch -> {
            UnifySwitch(config = trailingIcon.value)
        }
        is UnifyList.TrailingIcon.NoAction -> UnifyIcon(
            config = UnifyIcon.Config(
                tint = color,
                icon = trailingIcon.value
            )
        )
        null -> {}
    }
}