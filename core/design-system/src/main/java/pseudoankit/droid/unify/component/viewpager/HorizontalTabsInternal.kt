package pseudoankit.droid.unify.component.viewpager

import androidx.compose.foundation.layout.height
import androidx.compose.material.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.launch
import pseudoankit.droid.unify.component.textview.UnifyTextView
import pseudoankit.droid.unify.component.textview.UnifyTextViewConfig
import pseudoankit.droid.unify.token.UnifyColors

internal object HorizontalTabsInternal {

    @Composable
    fun HorizontalTabs(pagerState: PagerState, items: ImmutableList<HorizontalViewPagerConfig.Item>) {
        val coroutineScope = rememberCoroutineScope()
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                )
            },
            backgroundColor = UnifyColors.White
        ) {
            items.forEachIndexed { index, item ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page = index)
                        }
                    },
                    selectedContentColor = UnifyColors.Green800,
                    unselectedContentColor = UnifyColors.Black,
                    modifier = Modifier.height(40.dp)
                ) {
                    UnifyTextView(
                        config = UnifyTextViewConfig(
                            text = item.label,
                        )
                    )
                }
            }
        }
    }
}