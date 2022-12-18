package pseudoankit.droid.core.util.extension

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

inline fun <T, R> Iterable<T>.mapToImmutableList(transform: (T) -> R): ImmutableList<R> {
    return map {
        transform(it)
    }.toImmutableList()
}