package pseudoankit.droid.coreui.components.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class UnifyIcons(internal val iconType: IconTypes) {
    object Back : UnifyIcons(IconTypes.Vector(Icons.Default.ArrowBack))
    object Mail : UnifyIcons(IconTypes.Vector(Icons.Default.Email))
    object Lock : UnifyIcons(IconTypes.Vector(Icons.Default.Lock))
    object Check : UnifyIcons(IconTypes.Vector(Icons.Default.Check))

    // todo
    object EyeOff : UnifyIcons(IconTypes.Vector(Icons.Default.ArrowBack))
    object EyeOn : UnifyIcons(IconTypes.Vector(Icons.Default.KeyboardArrowRight))

    sealed interface IconTypes {
        data class Vector(val imageVector: ImageVector) : IconTypes
    }
}