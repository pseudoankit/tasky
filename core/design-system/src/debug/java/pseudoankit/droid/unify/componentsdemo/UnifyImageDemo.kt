package pseudoankit.droid.unify.componentsdemo

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pseudoankit.droid.unify.components.image.UnifyImage
import pseudoankit.droid.unify.components.textview.UnifyTextView

@Composable
internal fun UnifyImageDemo() {
    UnifyTextView(config = UnifyTextView.Config("Network Image"))
    UnifyImage(
        config = UnifyImage.Config(
            imageType = UnifyImage.Config.ImageType.Url("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pexels.com%2Fsearch%2Fbroken%2F&psig=AOvVaw3hMyzzmBLh-tP9PsOEJI39&ust=1673855448318000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCIirhMyLyfwCFQAAAAAdAAAAABAJ")
        )
    )
    Spacer(modifier = Modifier.height(16.dp))
    UnifyTextView(config = UnifyTextView.Config("Drawable Res"))
    UnifyImage(
        config = UnifyImage.Config(
            imageType = UnifyImage.Config.ImageType.DrawableRes(android.R.drawable.ic_menu_gallery)
        )
    )
}