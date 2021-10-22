package com.example.myapplication.ui.global.sub

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger

class SubViewModel : ViewModel() {
    private var counter = AtomicInteger(0)
    private val _text = MutableLiveData(counter.toString())
    val text: LiveData<String> = _text

    init {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                _text.postValue(counter.incrementAndGet().toString())
            }
        }
    }
}