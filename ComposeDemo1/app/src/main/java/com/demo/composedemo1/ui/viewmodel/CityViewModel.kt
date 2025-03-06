package com.demo.composedemo1.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.demo.composedemo1.data.model.City
import com.demo.composedemo1.data.repository.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(application: Application, private val repository: CityRepository) : AndroidViewModel(application) {
    val _cities = MutableLiveData<List<City>>()
    val cities: LiveData<List<City>> get() = _cities

    init {
        loadCities()
    }

    fun loadCities() {
        viewModelScope.launch {
            _cities.value = repository.getCities()
        }
    }

    fun reverseCities() {
        _cities.value = _cities.value?.reversed()
    }
}
