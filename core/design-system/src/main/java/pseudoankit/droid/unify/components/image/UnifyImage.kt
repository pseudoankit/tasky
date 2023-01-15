package pseudoankit.droid.unify.components.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import pseudoankit.droid.unify.components.image.UnifyImageInternal.getImageModel
import pseudoankit.droid.unify.utils.isLoading

object UnifyImage {
    @Composable
    operator fun invoke(config: Config) {
        when (config.imageType) {
            is Config.ImageType.DrawableRes -> Image(
                painter = painterResource(id = config.imageType.value),
                contentDescription = "",
                modifier = config.modifier,
                alignment = config.alignment,
                contentScale = config.contentScale,
                alpha = config.alpha,
                colorFilter = config.colorFilter
            )
            is Config.ImageType.Url -> {
                var isLoading by remember { mutableStateOf(false) }

                AsyncImage(
                    model = config.getImageModel(LocalContext.current),
                    contentDescription = null,
                    modifier = config.modifier.isLoading(isLoading = isLoading),
                    placeholder = painterResource(id = config.failurePlaceHolder),
                    fallback = painterResource(id = config.failurePlaceHolder),
                    error = painterResource(id = config.failurePlaceHolder),
                    onLoading = {
                        isLoading = true
                    },
                    onError = {
                        isLoading = false
                    },
                    onSuccess = {
                        isLoading = false
                    },
                    alignment = config.alignment,
                    contentScale = config.contentScale,
                    alpha = config.alpha,
                    colorFilter = config.colorFilter
                )
            }
        }
    }

    /**
     *  @param imageType image configuration to display
     *  @param failurePlaceHolder placeholder, required when image url loading fails
     *  @param alignment Optional alignment parameter used to place the [AsyncImagePainter] in the given
     *  bounds defined by the width and height.
     *  @param contentScale Optional scale parameter used to determine the aspect ratio scaling to be
     *  used if the bounds are a different size from the intrinsic size of the [AsyncImagePainter].
     *  @param alpha Optional opacity to be applied to the [AsyncImagePainter] when it is rendered
     *  onscreen.
     *  @param colorFilter Optional [ColorFilter] to apply for the [AsyncImagePainter] when it is
     *  rendered onscreen.
     */
    data class Config(
        val imageType: ImageType,
        @DrawableRes val failurePlaceHolder: Int,
        val modifier: Modifier = Modifier,
        val alignment: Alignment = Alignment.Center,
        val contentScale: ContentScale = ContentScale.Fit,
        val alpha: Float = DefaultAlpha,
        val colorFilter: ColorFilter? = null,
    ) {
        sealed interface ImageType {
            data class DrawableRes(val value: Int) : ImageType
            data class Url(val value: String) : ImageType
        }
    }
}
