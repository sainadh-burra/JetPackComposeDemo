package com.demo.composedemo1.data.repository

import android.content.Context
import com.demo.composedemo1.data.model.City
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CityRepository(private val context: Context) {
    fun getCities(): List<City> {
        val jsonString = context.assets.open("au_cities.json").bufferedReader().use { it.readText() }
        val cityListType = object : TypeToken<List<City>>() {}.type
        return Gson().fromJson(jsonString, cityListType)
    }
}