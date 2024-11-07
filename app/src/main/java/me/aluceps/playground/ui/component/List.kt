package me.aluceps.playground.ui.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.aluceps.playground.ui.theme.PlaygroundTheme

@Composable
fun ListScreen(
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

@Preview(showBackground = true)
@Composable
private fun ListScreenPreview() {
    PlaygroundTheme {
        ListScreen(
            onClick = {},
        )
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
