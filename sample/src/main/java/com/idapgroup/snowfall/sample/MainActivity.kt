package com.idapgroup.snowfall.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBackIos
import androidx.compose.material.icons.rounded.BackHand
import androidx.compose.material.icons.rounded.Cabin
import androidx.compose.material.icons.rounded.Cable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idapgroup.snowfall.sample.ui.theme.SnowfallTheme
import com.idapgroup.snowfall.snowfall
import com.idapgroup.snowfall.snowmelt
import com.idapgroup.snowfall.types.FlakeType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnowfallTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Snowfall()
                }
            }
        }
    }
}

@Composable
fun Snowfall(modifier: Modifier = Modifier) {
    val colors = listOf<Color>(
        Yellow, Green, White, Cyan, Blue
    )
    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.DarkGray, shape = RoundedCornerShape(8.dp))
                .snowfall(colors = colors, density = 0.1)
                .snowmelt(colors = colors)
        )
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.DarkGray, shape = RoundedCornerShape(8.dp))
                .snowmelt(colors = colors)
        )
        val data = listOf(
            rememberVectorPainter(image = Icons.Rounded.BackHand),
            rememberVectorPainter(image = Icons.Rounded.ArrowBack),
            rememberVectorPainter(image = Icons.Rounded.ArrowBackIos),
            rememberVectorPainter(image = Icons.Rounded.Cabin),
            rememberVectorPainter(image = Icons.Rounded.Cable),
        )
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(150.dp)
                .background(Blue, shape = RoundedCornerShape(8.dp))
                .snowfall(FlakeType.Custom(data),colors = colors)
        )
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                .snowmelt(FlakeType.Custom(data),colors = colors)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnowfallTheme {
        Snowfall()
    }
}