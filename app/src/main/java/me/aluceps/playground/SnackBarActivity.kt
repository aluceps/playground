package me.aluceps.playground

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import me.aluceps.playground.ui.theme.PlaygroundTheme

@OptIn(ExperimentalMaterial3Api::class)
class SnackBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundTheme {
                val scope = rememberCoroutineScope()
                val snackbarHostState = remember { SnackbarHostState() }
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = this::class.simpleName ?: "")
                            }
                        )
                    },
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    },
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Button(onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar("This is snackbar")
                            }
                        }) {
                            Text(text = "SnackBarを表示")
                        }
                    }
                }
            }
        }
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(
                Intent(context, SnackBarActivity::class.java).apply {
                }
            )
        }
    }
}
