package pseudoankit.droid.unify.component.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import lazycoder21.droid.compose.FaIcon
import lazycoder21.droid.compose.FaIcons
import pseudoankit.droid.unify.utils.UnifyDrawable

sealed class UnifyIcons(internal val iconType: IconType) {
    object Back : UnifyIcons(IconType.Vector(Icons.Default.ArrowBack))
    object Mail : UnifyIcons(IconType.Vector(Icons.Default.Email))
    object Lock : UnifyIcons(IconType.Vector(Icons.Default.Lock))
    object Check : UnifyIcons(IconType.Vector(Icons.Default.Check))
    object DropDown : UnifyIcons(IconType.Vector(Icons.Default.ArrowDropDown))
    object Add : UnifyIcons(IconType.Vector(Icons.Default.Add))
    object Refresh : UnifyIcons(IconType.Vector(Icons.Default.Refresh))
    object Person : UnifyIcons(IconType.Vector(Icons.Default.Person))

    object CheckCircle : UnifyIcons(IconType.FontAwesome(FaIcons.CheckCircleRegular))
    object EyeOff : UnifyIcons(IconType.FontAwesome(FaIcons.EyeSlash))
    object EyeOn : UnifyIcons(IconType.FontAwesome(FaIcons.Eye))
    object Cross : UnifyIcons(IconType.FontAwesome(FaIcons.Times))
    object Bell : UnifyIcons(IconType.Svg(UnifyDrawable.ic_notification))
    object Calendar : UnifyIcons(IconType.FontAwesome(FaIcons.CalendarCheck))
    object Tasks : UnifyIcons(IconType.FontAwesome(FaIcons.Tasks))
    object Clock : UnifyIcons(IconType.FontAwesome(FaIcons.ClockRegular))
    object EllipsisV : UnifyIcons(IconType.FontAwesome(FaIcons.EllipsisV))
    object Circle : UnifyIcons(IconType.FontAwesome(FaIcons.CircleRegular))
    object Delete : UnifyIcons(IconType.FontAwesome(FaIcons.Trash))
    object Edit : UnifyIcons(IconType.FontAwesome(FaIcons.Pen))
    object User : UnifyIcons(IconType.FontAwesome(FaIcons.User))

    sealed interface IconType {
        data class Vector(val imageVector: ImageVector) : IconType
        data class FontAwesome(val faIcon: FaIcon) : IconType
        data class Svg(@DrawableRes val drawableRes: Int) : IconType
    }
}