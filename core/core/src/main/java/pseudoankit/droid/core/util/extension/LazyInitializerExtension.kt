package pseudoankit.droid.core.util.extension

fun <T> nonThreadSafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)