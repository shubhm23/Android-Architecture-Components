package com.example.mvvmwithretrofitandroom.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmwithretrofitandroom.api.QuoteService
import com.example.mvvmwithretrofitandroom.models.QuoteList

class QuoteRepository (private val quoteService: QuoteService){

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
    get() = quotesLiveData

    suspend fun getQuote(page: Int){
        val result = quoteService.getQuotes(page)
        if(result?.body() != null){
            quotesLiveData.postValue(result.body())
        }
    }

}