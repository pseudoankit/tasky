package pseudoankit.droid.core.deeplink

import android.content.Intent
import android.net.Uri

object DeepLinkUtil {
    fun createDeeplinkIntent(deeplinkUri: String): Intent {
        return Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(deeplinkUri)
        }
    }
}