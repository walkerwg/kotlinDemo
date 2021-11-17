package com.example.myapplication.test.weatherMVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {

    var data: MutableLiveData<WeatherModel> = MutableLiveData()
    var list:LiveData<WeatherModel> = data

    init {
        data.value = WeatherModel("34",55F)
    }
}