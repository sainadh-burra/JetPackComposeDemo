package com.demo.composedemo1.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.composedemo1.data.repository.CityRepository
import javax.inject.Inject

class CityViewModelFactory @Inject constructor(
    private val application: Application,
    private val repository: CityRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CityViewModel::class.java)) {
            return CityViewModel(application, repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}