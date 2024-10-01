package me.aluceps.playground

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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

class PagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundTheme {
                PagerScreen(
                    initialPage = intent.getIntExtra(INITIAL_PAGE, 0)
                )
            }
        }
    }

    companion object {
        private const val INITIAL_PAGE = "initial_page"
        fun startActivity(context: Context, initialPage: Int) {
            context.startActivity(
                Intent(context, PagerActivity::class.java).apply {
                    putExtra(INITIAL_PAGE, initialPage)
                }
            )
        }
    }
}

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
