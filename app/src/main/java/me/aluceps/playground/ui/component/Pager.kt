package me.aluceps.playground.ui.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import me.aluceps.playground.ui.theme.PlaygroundTheme
import me.aluceps.playground.ui.theme.Typography

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerScreen(
    initialPage: Int = 0
) {
    val pagerState = rememberPagerState(
        initialPage = initialPage,
        pageCount = { 10 }
    )
    VerticalPager(state = pagerState) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Pager $it",
                style = Typography.labelLarge.copy(
                    fontSize = 32.sp,
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PagerScreenPreview() {
    PlaygroundTheme {
        PagerScreen()
    }
}
