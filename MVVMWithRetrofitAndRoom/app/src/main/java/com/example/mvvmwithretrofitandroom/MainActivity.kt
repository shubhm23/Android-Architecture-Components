package com.example.mvvmwithretrofitandroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithretrofitandroom.api.QuoteService
import com.example.mvvmwithretrofitandroom.api.RetrofitHelper
import com.example.mvvmwithretrofitandroom.repository.QuoteRepository
import com.example.mvvmwithretrofitandroom.viewmodels.MainViewModel
import com.example.mvvmwithretrofitandroom.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)

        val repository = QuoteRepository(quoteService)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("Shubham", it.results.toString())
        })
    }
}