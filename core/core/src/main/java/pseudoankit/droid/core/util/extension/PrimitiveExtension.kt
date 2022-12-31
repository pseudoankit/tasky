package pseudoankit.droid.core.util.extension

val Boolean?.orFalse get() = this ?: false
val Boolean?.orTrue get() = this ?: true