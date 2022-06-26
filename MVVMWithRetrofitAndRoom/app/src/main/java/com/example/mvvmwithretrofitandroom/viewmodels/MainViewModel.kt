package com.example.mvvmwithretrofitandroom.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithretrofitandroom.models.QuoteList
import com.example.mvvmwithretrofitandroom.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuote(1)
        }
    }

    val quotes : LiveData<QuoteList>
    get() = repository.quotes

}