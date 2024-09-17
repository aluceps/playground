package me.aluceps.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.aluceps.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        onClick = {
                            PagerActivity.startActicity(this, it)
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(10) {
            ListItem(
                name = "item no.$it",
                onClick = { onClick(it) }
            )
        }
    }
}

@Composable
fun ListItem(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(onClick = onClick) {
        Text(
            text = name,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ListItemPreview() {
    PlaygroundTheme {
        ListItem(
            name = "Android",
            onClick = {},
        )
    }
}
