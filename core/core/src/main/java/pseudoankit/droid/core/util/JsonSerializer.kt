package pseudoankit.droid.core.util

import kotlinx.serialization.json.Json

val defaultJsonSerializer = Json {
    isLenient = true
    explicitNulls = true
    ignoreUnknownKeys = true
}