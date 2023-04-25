package com.example.composecanvas

import android.content.res.Resources
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecanvas.ui.theme.Blue
import com.example.composecanvas.ui.theme.BlueBorder

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CustomViewPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState = rememberPagerState()
) {
    val list = listOf("122", "332", "453", "476", "835", "096", "724")
    var size by remember { mutableStateOf(0) }
    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth()
    ) {
            HorizontalPager(
                modifier = modifier
                    .fillMaxWidth()
                    .onSizeChanged {
                        size = (it.width - 80.toPx)
                    },
                state = pagerState,
                pageCount = list.size,
                pageSize = PageSize.Fixed(80.dp),
                verticalAlignment = Alignment.CenterVertically,
                contentPadding = PaddingValues(start = (size / 2).toDp.dp)
            ) { position ->
                if (pagerState.currentPage == position) {
                    ViewPagerItemComposable(
                        itemText = list[position], extraHeight = 5f, extraWidth = 10f
                    )
                } else {
                    ViewPagerItemComposable(itemText = list[position])
                }
            }
    }
}

@Composable
fun ViewPagerItemComposable(
    modifier: Modifier = Modifier,
    itemText: String,
    extraWidth: Float = 0f,
    extraHeight: Float = 0f
) {
    BoxWithConstraints() {
        Column(
            modifier = modifier
                .padding(5.dp)
                .size((50 + extraWidth).dp, (30 + extraHeight).dp)
                .background(color = Blue, shape = RoundedCornerShape(7.dp))
                .border(width = 0.7.dp, color = BlueBorder, shape = RoundedCornerShape(7.dp))
            ,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = itemText,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }

}


val Int.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Int.toDp get() = (this / Resources.getSystem().displayMetrics.density).toInt()


@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun ComposeViewPagerTextingPreview() {
    CustomViewPager()
}