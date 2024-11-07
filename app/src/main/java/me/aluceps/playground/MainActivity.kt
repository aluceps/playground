package me.aluceps.playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import me.aluceps.playground.ui.theme.PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        Button(onClick = {
                            ListActivity.startActivity(this@MainActivity)
                        }) {
                            Text(
                                text = "ListActivityを起動"
                            )
                        }
                        Button(onClick = {
                            SnackBarActivity.startActivity(this@MainActivity)
                        }) {
                            Text(
                                text = "SnackBarActivityを起動"
                            )
                        }
                    }
                }
            }
        }
    }
}
