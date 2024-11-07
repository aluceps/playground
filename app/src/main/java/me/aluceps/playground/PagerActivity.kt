package me.aluceps.playground

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.aluceps.playground.ui.component.PagerScreen
import me.aluceps.playground.ui.theme.PlaygroundTheme

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
