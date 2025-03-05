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
            .padding(8.dp)
    ) {
        groupedCities.forEach { (state, cities) ->
            item {
                Text(
                    state ?: "AU Cities",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier
                        .padding(8.dp)
                        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
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
                        Text(city.city ?: "Unknown City", style = MaterialTheme.typography.bodyLarge)
                        Text("Latitude: ${city.lat ?: "Unknown"}", style = MaterialTheme.typography.bodySmall)
                        Text("Longitude: ${city.lng ?: "Unknown"}", style = MaterialTheme.typography.bodySmall)
                        Text("Country: ${city.country ?: "Unknown"}", style = MaterialTheme.typography.bodySmall)
                        Text("Population: ${city.population ?: "Unknown"}", style = MaterialTheme.typography.bodySmall)
                        Text("Proper Population: ${city.populationProper ?: "Unknown"}", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}