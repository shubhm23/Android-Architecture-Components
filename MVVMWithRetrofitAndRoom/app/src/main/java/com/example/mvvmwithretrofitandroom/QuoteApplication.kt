package com.example.mvvmwithretrofitandroom

import android.app.Application
import com.example.mvvmwithretrofitandroom.api.QuoteService
import com.example.mvvmwithretrofitandroom.api.RetrofitHelper
import com.example.mvvmwithretrofitandroom.db.QuoteDatabase
import com.example.mvvmwithretrofitandroom.repository.QuoteRepository

class QuoteApplication: Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        quoteRepository = QuoteRepository(quoteService, database, applicationContext)
    }
}