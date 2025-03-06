package com.demo.composedemo1.data.repository

import android.content.Context
import com.demo.composedemo1.data.model.City
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class CityRepository @Inject constructor(private val context: Context) {
    suspend fun getCities(): List<City> = withContext(Dispatchers.IO) {
        val jsonString = context.assets.open("au_cities.json").bufferedReader().use { it.readText() }
        val cityListType = object : TypeToken<List<City>>() {}.type
        Gson().fromJson(jsonString, cityListType)
    }
}