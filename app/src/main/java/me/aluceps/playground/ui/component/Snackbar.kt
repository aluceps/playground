package me.aluceps.playground.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomSnackbar(
    snackbarHostState: SnackbarHostState
) {
    Box(
        modifier = Modifier
            .systemBarsPadding()
            .fillMaxSize()
            .padding(12.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        SnackbarHost(
            hostState = snackbarHostState,
            snackbar = { snackbarData ->
                CustomSnackbarBody(
                    message = snackbarData.visuals.message
                )
            }
        )
    }
}

@Composable
private fun CustomSnackbarBody(
    modifier: Modifier = Modifier,
    message: String,
//    elevationSize: Int = 4,
    cornerSize: Int = 8,
    paddingSize: Int = 4,
    contentPaddingSize: Int = 12,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingSize.dp),
//            .shadow(
//                elevation = elevationSize.dp,
//                shape = RoundedCornerShape(cornerSize.dp),
//                ambientColor = Color.Transparent,
//                spotColor = Color.Black
//            )
        shape = RoundedCornerShape(cornerSize.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color.White,
            containerColor = Color.Red,
        ),
    ) {
        Text(
            modifier = Modifier
                .padding(contentPaddingSize.dp),
            text = message,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CustomSnackbarBodyPreview() {
    CustomSnackbarBody(
        message = "aiueoaiueo"
    )
}
