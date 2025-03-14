package com.demo.composedemo1.ui.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.demo.composedemo1.data.model.City

@Composable
fun CityList(groupedCities: Map<String?, List<City>>) {
    LazyColumn(
        modifier = Modifier
            .padding(8.dp)
            .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        groupedCities.forEach { (state, cities) ->
            item {
                Text(
                    state ?: "Unknown State",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                cities.forEach { city ->
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(city.city ?: "Unknown City", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primaryContainer)
                        Text("Latitude: ${city.lat ?: "Unknown"}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondaryContainer)
                        Text("Longitude: ${city.lng ?: "Unknown"}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondaryContainer)
                        Text("Country: ${city.country ?: "Unknown"}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondaryContainer)
                        Text("Population: ${city.population ?: "Unknown"}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondaryContainer)
                        Text("Proper Population: ${city.population_proper ?: "Unknown"}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondaryContainer)
                    }
                }
            }
        }
    }
}