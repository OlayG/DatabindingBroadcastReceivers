package com.example.databindingbroadcastreceivers.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.databindingbroadcastreceivers.model.Bottle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _bottle = MutableLiveData(Bottle(0, "<b>Wate</b>"))
    val bottle: LiveData<Bottle>
        get() = _bottle


    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            _bottle.postValue(Bottle(1, "<b>Fanta</b>"))
        }
    }
}