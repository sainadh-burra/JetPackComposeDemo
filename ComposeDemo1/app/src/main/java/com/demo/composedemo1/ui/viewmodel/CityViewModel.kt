package com.demo.composedemo1.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demo.composedemo1.data.model.City
import com.demo.composedemo1.data.repository.CityRepository

class CityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = CityRepository(application)
    private val _cities = MutableLiveData<List<City>>()
    val cities: LiveData<List<City>> get() = _cities

    init {
        loadCities()
    }

    private fun loadCities() {
        _cities.value = repository.getCities()
    }

    fun reverseCities() {
        _cities.value = _cities.value?.reversed()
    }
}
