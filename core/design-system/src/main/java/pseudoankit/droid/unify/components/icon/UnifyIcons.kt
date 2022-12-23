package pseudoankit.droid.unify.components.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import lazycoder21.droid.compose.FaIcon
import lazycoder21.droid.compose.FaIcons

sealed class UnifyIcons(internal val iconType: IconType) {
    object Back : UnifyIcons(IconType.Vector(Icons.Default.ArrowBack))
    object Mail : UnifyIcons(IconType.Vector(Icons.Default.Email))
    object Lock : UnifyIcons(IconType.Vector(Icons.Default.Lock))
    object Check : UnifyIcons(IconType.Vector(Icons.Default.Check))
    object DropDown : UnifyIcons(IconType.Vector(Icons.Default.ArrowDropDown))
    object Add : UnifyIcons(IconType.Vector(Icons.Default.Add))
    object CheckCircle : UnifyIcons(IconType.Vector(Icons.Default.CheckCircle))

    object EyeOff : UnifyIcons(IconType.FontAwesome(FaIcons.EyeSlash))
    object EyeOn : UnifyIcons(IconType.FontAwesome(FaIcons.Eye))
    object Cross : UnifyIcons(IconType.FontAwesome(FaIcons.Times))
    object Bell : UnifyIcons(IconType.FontAwesome(FaIcons.Bell))
    object Calendar : UnifyIcons(IconType.FontAwesome(FaIcons.CalendarCheck))
    object Tasks : UnifyIcons(IconType.FontAwesome(FaIcons.Tasks))
    object Clock : UnifyIcons(IconType.FontAwesome(FaIcons.ClockRegular))

    sealed interface IconType {
        data class Vector(val imageVector: ImageVector) : IconType
        data class FontAwesome(val faIcon: FaIcon) : IconType
    }
}