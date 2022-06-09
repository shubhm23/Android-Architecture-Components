package com.example.viewmodel


import androidx.lifecycle.ViewModel

class MainViewModel(var initialVal: Int): ViewModel() {
    var count: Int = initialVal
    fun increment(){
        count++
    }
}