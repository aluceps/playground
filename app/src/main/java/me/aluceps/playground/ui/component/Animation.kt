package me.aluceps.playground.ui.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import me.aluceps.playground.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun ImageContainerPreview() {
    val images = listOf(
        R.drawable.elephant_apng_zopfli_41_7ms_1,
        R.drawable.elephant_apng_zopfli_41_7ms_2,
        R.drawable.elephant_apng_zopfli_41_7ms_3,
        R.drawable.elephant_apng_zopfli_41_7ms_4,
        R.drawable.elephant_apng_zopfli_41_7ms_5,
        R.drawable.elephant_apng_zopfli_41_7ms_6,
        R.drawable.elephant_apng_zopfli_41_7ms_7,
        R.drawable.elephant_apng_zopfli_41_7ms_8,
        R.drawable.elephant_apng_zopfli_41_7ms_9,
        R.drawable.elephant_apng_zopfli_41_7ms_10,
        R.drawable.elephant_apng_zopfli_41_7ms_11,
        R.drawable.elephant_apng_zopfli_41_7ms_12,
        R.drawable.elephant_apng_zopfli_41_7ms_13,
        R.drawable.elephant_apng_zopfli_41_7ms_14,
        R.drawable.elephant_apng_zopfli_41_7ms_15,
        R.drawable.elephant_apng_zopfli_41_7ms_16,
        R.drawable.elephant_apng_zopfli_41_7ms_17,
        R.drawable.elephant_apng_zopfli_41_7ms_18,
        R.drawable.elephant_apng_zopfli_41_7ms_19,
        R.drawable.elephant_apng_zopfli_41_7ms_20,
        R.drawable.elephant_apng_zopfli_41_7ms_21,
        R.drawable.elephant_apng_zopfli_41_7ms_22,
        R.drawable.elephant_apng_zopfli_41_7ms_23,
        R.drawable.elephant_apng_zopfli_41_7ms_24,
        R.drawable.elephant_apng_zopfli_41_7ms_25,
        R.drawable.elephant_apng_zopfli_41_7ms_26,
        R.drawable.elephant_apng_zopfli_41_7ms_27,
        R.drawable.elephant_apng_zopfli_41_7ms_28,
        R.drawable.elephant_apng_zopfli_41_7ms_29,
        R.drawable.elephant_apng_zopfli_41_7ms_30,
        R.drawable.elephant_apng_zopfli_41_7ms_31,
        R.drawable.elephant_apng_zopfli_41_7ms_32,
        R.drawable.elephant_apng_zopfli_41_7ms_33,
        R.drawable.elephant_apng_zopfli_41_7ms_34,
    )

    var enabled by remember { mutableStateOf(false) }
    val index = animateIntAsState(
        targetValue = if (enabled) images.size else 0,
        animationSpec = infiniteRepeatable(
            // durationMillis: 開始から終了までの総時間
            animation = tween(
                durationMillis = 42 * 34,
                easing = LinearEasing,
            )
        ),
        label = "sample animation",
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = images[index.value]),
            contentDescription = null,
        )
        Text(
            text = "%02d / %d".format(
                index.value + 1,
                images.size,
            )
        )
        Slider(
            state = SliderState(
                value = index.value.toFloat(),
                valueRange = 0f..(images.size - 1).coerceAtLeast(0).toFloat()
            ),
            thumb = {},
        )
        Button(
            onClick = {
                enabled = true
            },
            enabled = enabled.not()
        ) {
            Text(
                text = if (enabled) {
                    "running..."
                } else {
                    "start"
                }
            )
        }
    }
}
