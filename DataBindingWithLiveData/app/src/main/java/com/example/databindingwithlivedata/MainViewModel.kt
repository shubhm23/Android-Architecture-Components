package com.example.databindingwithlivedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var liveDataQuote = MutableLiveData("This is a quote")

    fun updateQuote(){
        liveDataQuote.value = "Here is another quote"
    }

}