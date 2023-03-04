package pseudoankit.droid.unify.component.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.unify.component.icon.UnifyIcons
import pseudoankit.droid.unify.component.switch.UnifySwitchConfig
import pseudoankit.droid.unify.token.UnifyColors

@SuppressLint("ComposeModifierMissing")
@Composable
fun UnifyListItem(config: UnifyListItemConfig) {
    Row(
        modifier = config.modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        UnifyListComponents.LeadingIcon(
            leadingIcon = config.leadingIcon,
            tint = config.color
        )

        UnifyListComponents.Label(
            label = config.label,
            color = config.color,
            modifier = Modifier.weight(1f)
        )

        UnifyListComponents.TrailingIcon(
            trailingIcon = config.trailingSection,
            color = config.color
        )
    }
}

data class UnifyListItemConfig(
    val leadingIcon: UnifyIcons? = null,
    val label: String,
    val trailingSection: TrailingSection? = null,
    val modifier: Modifier = Modifier,
    val color: Color = UnifyColors.Black
) {

    sealed interface TrailingSection {
        @JvmInline
        value class Switch(val value: UnifySwitchConfig) : TrailingSection

        @JvmInline
        value class NoAction(val value: UnifyIcons) : TrailingSection
    }
}