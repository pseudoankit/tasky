package pseudoankit.droid.coreui.components.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TaskyIcons(internal val iconType: IconTypes) {
    object Back : TaskyIcons(IconTypes.Vector(Icons.Default.ArrowBack))

    sealed interface IconTypes {
        data class Vector(val imageVector: ImageVector) : IconTypes
    }
}