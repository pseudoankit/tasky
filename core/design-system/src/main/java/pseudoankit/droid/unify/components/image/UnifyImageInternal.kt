package pseudoankit.droid.unify.components.image

import android.content.Context
import coil.decode.SvgDecoder
import coil.request.ImageRequest

internal object UnifyImageInternal {
    internal fun UnifyImage.Config.getImageModel(context: Context): Any = when (imageType) {
        is UnifyImage.Config.ImageType.DrawableRes -> imageType.value
        is UnifyImage.Config.ImageType.Url -> getImageRequest(imageType.value, context)
    }

    private fun UnifyImage.Config.getImageRequest(url: String, context: Context): ImageRequest {
        return ImageRequest.Builder(context).apply {
            data(url)
            if (url.endsWith("svg")) {
                decoderFactory(SvgDecoder.Factory())
            }
        }.build()
    }
}