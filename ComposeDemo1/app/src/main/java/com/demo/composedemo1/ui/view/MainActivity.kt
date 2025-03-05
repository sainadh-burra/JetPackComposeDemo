package com.demo.composedemo1.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.composedemo1.ui.theme.ComposeDemo1Theme
import com.demo.composedemo1.ui.theme.DarkColors
import com.demo.composedemo1.ui.theme.LightColors
import com.demo.composedemo1.ui.viewmodel.CityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: CityViewModel = CityViewModel(application)
            MaterialTheme(
                colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    ReverseButton { viewModel.reverseCities() }
                    CityList(viewModel.cities.observeAsState(emptyList()).value.groupBy { it.admin_name })
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemo1Theme {
        Greeting("Android")
    }
}