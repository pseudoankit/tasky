package pseudoankit.droid.unify.component.viewpager

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.collections.immutable.ImmutableList
import pseudoankit.droid.unify.token.UnifyColors

data class HorizontalViewPagerConfig(
    val items: ImmutableList<Item>,
    val unSelectedColor: Color = UnifyColors.Black,
    val selectedColor: Color = UnifyColors.Green800,
    val modifier: Modifier = Modifier.fillMaxSize()
) {

    data class Item(
        val label: String,
        val tag: Tag
    )

    interface Tag
}

@Composable
fun HorizontalViewPager(
    config: HorizontalViewPagerConfig,
    content: @Composable (position: Int, tag: HorizontalViewPagerConfig.Tag) -> Unit
) {
    val pagerState = rememberPagerState()

    Column(modifier = config.modifier) {
        HorizontalTabsInternal.HorizontalTabs(items = config.items, pagerState = pagerState)
        HorizontalPager(
            count = config.items.size,
            state = pagerState
        ) { currentPage ->
            val item = config.items.getOrNull(currentPage) ?: return@HorizontalPager
            content.invoke(currentPage, item.tag)
        }
    }
}