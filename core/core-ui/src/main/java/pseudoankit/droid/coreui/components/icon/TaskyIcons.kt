package pseudoankit.droid.coreui.components.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TaskyIcons(internal val iconType: IconTypes) {
    object Back : TaskyIcons(IconTypes.Vector(Icons.Default.ArrowBack))
    object Mail : TaskyIcons(IconTypes.Vector(Icons.Default.Email))
    object Lock : TaskyIcons(IconTypes.Vector(Icons.Default.Lock))
    object Check : TaskyIcons(IconTypes.Vector(Icons.Default.Check))

    // todo
    object EyeOff : TaskyIcons(IconTypes.Vector(Icons.Default.ArrowBack))
    object EyeOn : TaskyIcons(IconTypes.Vector(Icons.Default.KeyboardArrowRight))

    sealed interface IconTypes {
        data class Vector(val imageVector: ImageVector) : IconTypes
    }
}