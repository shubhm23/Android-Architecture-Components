package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quotesAPI = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        GlobalScope.launch {
            val result = quotesAPI.getQuotes(1)
            if(result != null){
                val quoteList = result.body()
                if (quoteList != null) {
                    quoteList.results.forEach {
                        Log.d("Shubham", it.content)
                    }
                }
            }
        }
    }
}