package com.example.mvvm

import androidx.lifecycle.LiveData

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuotes(): LiveData<List<Quote>>{
        return quoteDao.getQuote()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }

}