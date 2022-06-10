package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    //Creating a Mutable LiveData object
    private val factsLiveDataObject = MutableLiveData<String>("This is a fact")

    val factsLiveData : LiveData<String>
    get() = factsLiveDataObject

    fun updateLiveData(){
        factsLiveDataObject.value = "Another Fact"
    }

}