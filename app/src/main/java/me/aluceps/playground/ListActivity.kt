package me.aluceps.playground

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import me.aluceps.playground.ui.component.ListScreen
import me.aluceps.playground.ui.theme.PlaygroundTheme

@OptIn(ExperimentalMaterial3Api::class)
class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = this::class.simpleName ?: "")
                            }
                        )
                    }
                ) { innerPadding ->
                    ListScreen(
                        onClick = {
                            PagerActivity.startActivity(this, it)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(
                Intent(context, ListActivity::class.java).apply {
                }
            )
        }
    }
}
