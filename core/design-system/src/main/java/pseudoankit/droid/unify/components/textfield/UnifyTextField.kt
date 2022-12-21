package pseudoankit.droid.unify.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textview.UnifyTextType

object UnifyTextField {

    @Composable
    operator fun invoke(config: Config) {
        UnifyTextFieldInternal(config)
    }

    data class Config(
        val value: String,
        val onValueChange: (String) -> Unit,
        val keyboardType: KeyboardType = KeyboardType.Text,
        val placeholder: String? = null,
        val leadingIcon: UnifyIcons? = null,
        val trailingIcon: Icon? = null,
        val showTrailingIcon: Boolean = true,
        val errorMessage: String? = null,
        val modifier: Modifier = Modifier.fillMaxWidth(),
        val maxLines: Int = Int.MAX_VALUE,
        val textType: UnifyTextType = UnifyTextType.BodyLarge
    )

    sealed interface Icon {
        object Valid : Icon
        object Password : Icon
        data class Custom(val icon: UnifyIcons, val onClick: () -> Unit) : Icon
    }
}