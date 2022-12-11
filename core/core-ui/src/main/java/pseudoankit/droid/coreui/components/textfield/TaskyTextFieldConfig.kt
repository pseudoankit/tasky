package pseudoankit.droid.coreui.components.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import pseudoankit.droid.core.util.TextResource
import pseudoankit.droid.coreui.components.icon.TaskyIcons

data class TaskyTextFieldConfig(
    val value: String,
    val onValueChange: (String) -> Unit,
    val keyboardType: KeyboardType = KeyboardType.Text,
    val placeholder: TextResource? = null,
    val leadingIcon: TaskyIcons? = null,
    val trailingIcon: Icon? = null,
    val errorMessage: TextResource? = null,
    val modifier: Modifier = Modifier.fillMaxWidth(),
    val maxLines: Int = Int.MAX_VALUE
) {
    sealed interface Icon {
        object Valid : Icon
        object Password : Icon
        data class Custom(val icon: TaskyIcons, val onClick: () -> Unit) : Icon
    }
}