package pseudoankit.droid.unify.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import pseudoankit.droid.unify.components.icon.UnifyIcons
import pseudoankit.droid.unify.components.textfield.internal.UnifyBasicTextField
import pseudoankit.droid.unify.components.textfield.internal.UnifyOutlinedTextField
import pseudoankit.droid.unify.components.textview.UnifyTextType

object UnifyTextField {

    @Composable
    operator fun invoke(config: Config) {
        when (config.type) {
            Type.Outlined -> {
                UnifyOutlinedTextField(config)
            }
            Type.Basic -> {
                UnifyBasicTextField(config)
            }
        }
    }

    enum class Type { Outlined, Basic }

    data class Config(
        val value: String,
        val onValueChange: (String) -> Unit,
        val keyboardType: KeyboardType = KeyboardType.Text,
        val placeholder: String? = null,
        val leadingIcon: UnifyIcons? = null,
        val trailingIcon: TrailingIcon? = null,
        val showTrailingIcon: Boolean = true,
        val errorMessage: String? = null,
        val modifier: Modifier = Modifier.fillMaxWidth(),
        val maxLines: Int = Int.MAX_VALUE,
        val textType: UnifyTextType = UnifyTextType.BodyLarge,
        val type: Type = Type.Outlined
    )

    sealed interface TrailingIcon {
        object Valid : TrailingIcon
        data class Password(
            val isTextHidden: Boolean = false,
            val onVisibilityToggled: () -> Unit
        ) : TrailingIcon

        data class Custom(val icon: UnifyIcons, val onClick: () -> Unit) : TrailingIcon
    }
}