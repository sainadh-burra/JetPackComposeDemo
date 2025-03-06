package com.demo.composedemo1.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.demo.composedemo1.data.repository.CityRepository
import com.demo.composedemo1.ui.theme.DarkColors
import com.demo.composedemo1.ui.theme.LightColors
import com.demo.composedemo1.ui.viewmodel.CityViewModel
import com.demo.composedemo1.ui.viewmodel.CityViewModelFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create the factory
        val factory = CityViewModelFactory(application, CityRepository(applicationContext))
        // Use the factory to get the ViewModel
        viewModel = ViewModelProvider(this, factory).get(CityViewModel::class.java)
        setContent {
            MaterialTheme(
                colorScheme = if (isSystemInDarkTheme()) DarkColors else LightColors
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .border(2.dp, Color.Gray, RoundedCornerShape(8.dp))
                            .padding(16.dp)
                    ) {
                        ReverseButton { viewModel.reverseCities() }
                        CityList(viewModel.cities.observeAsState(emptyList()).value.groupBy { it.admin_name })
                    }
                }
            }
        }
    }
}