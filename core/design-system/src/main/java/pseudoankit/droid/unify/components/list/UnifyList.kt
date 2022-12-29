package pseudoankit.droid.unify.components.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.switch.UnifySwitch
import pseudoankit.droid.unify.token.UnifyColors
import pseudoankit.droid.unify.token.UnifyDimens

object UnifyList {

    @Composable
    operator fun invoke(config: Config) = Row(
        modifier = config.modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        UnifyListComponents.LeadingIcon(config.leadingIcon, config.color)
        if (config.leadingIcon != null) {
            Spacer(modifier = Modifier.width(UnifyDimens.Dp_16))
        }
        UnifyListComponents.Label(config.label, config.color)
        Spacer(modifier = Modifier.weight(1f))
        UnifyListComponents.TrailingIcon(config.trailingIcon, config.color)
    }

    data class Config(
        val leadingIcon: UnifyIcons? = null,
        val label: String,
        val trailingIcon: TrailingIcon? = null,
        val modifier: Modifier = Modifier,
        val color: Color = UnifyColors.Black
    )

    sealed interface TrailingIcon {
        @JvmInline
        value class Switch(val value: UnifySwitch.Config) : TrailingIcon

        @JvmInline
        value class NoAction(val value: UnifyIcons) : TrailingIcon
    }
}