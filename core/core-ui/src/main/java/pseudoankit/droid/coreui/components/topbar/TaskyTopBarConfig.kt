package pseudoankit.droid.coreui.components.topbar

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import pseudoankit.droid.coreui.components.icon.TaskyIconConfig
import pseudoankit.droid.coreui.components.text.TaskyTextConfig
import pseudoankit.droid.coreui.token.TaskyColor

data class TaskyTopBarConfig(
    val leadingIcon: TaskyIconConfig? = null,
    val title: String = "",
    val type: Type = Type.Small,
    val trailingSection: TrailingSection? = null,
    val tintColor: Color = TaskyColor.White
) {

    data class TrailingSection(
        val text: TaskyTextConfig?,
        val icon: TaskyIconConfig?,
        val modifier: Modifier = Modifier
    )

    enum class Type { Small }
}