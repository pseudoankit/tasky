package pseudoankit.droid.coreui.components.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.graphics.vector.ImageVector
import lazycoder21.droid.compose.FaIcon
import lazycoder21.droid.compose.FaIcons

sealed class UnifyIcons(internal val iconType: IconType) {
    object Back : UnifyIcons(IconType.Vector(Icons.Default.ArrowBack))
    object Mail : UnifyIcons(IconType.Vector(Icons.Default.Email))
    object Lock : UnifyIcons(IconType.Vector(Icons.Default.Lock))
    object Check : UnifyIcons(IconType.Vector(Icons.Default.Check))
    object EyeOff : UnifyIcons(IconType.FontAwesome(FaIcons.EyeSlash))
    object EyeOn : UnifyIcons(IconType.FontAwesome(FaIcons.Eye))

    sealed interface IconType {
        data class Vector(val imageVector: ImageVector) : IconType
        data class FontAwesome(val faIcon: FaIcon) : IconType
    }
}