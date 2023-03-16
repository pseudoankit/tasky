package pseudoankit.droid.unify.component.icon

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun UnifyIconInternal(config: UnifyIconConfig) {
    when (config.icon.iconType) {
        is UnifyIcons.IconType.FontAwesome -> FontAwesomeIcon(config = config)
        is UnifyIcons.IconType.Vector -> VectorIcon(config = config)
        is UnifyIcons.IconType.Svg -> SvgIcon(config = config)
    }
}

@Composable
private fun SvgIcon(config: UnifyIconConfig) {
    val icon = (config.icon.iconType as? UnifyIcons.IconType.Svg)?.drawableRes ?: return
    Icon(
        painter = painterResource(id = icon),
        contentDescription = "",
        modifier = Modifier.size(config.size),
        tint = config.tint
    )
}

@Composable
private fun FontAwesomeIcon(config: UnifyIconConfig) {
    val faIcon = (config.icon.iconType as? UnifyIcons.IconType.FontAwesome)?.faIcon ?: return

    lazycoder21.droid.compose.FontAwesomeIcon(
        faIcon = faIcon,
        size = config.size,
        tint = config.tint
    )
}

@Composable
private fun VectorIcon(config: UnifyIconConfig) {
    val imageVector =
        (config.icon.iconType as? UnifyIcons.IconType.Vector)?.imageVector ?: return
    Icon(
        imageVector = imageVector,
        contentDescription = config.contentDescription,
        modifier = Modifier.size(config.size),
        tint = config.tint
    )
}