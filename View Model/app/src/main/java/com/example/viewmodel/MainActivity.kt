package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var txtCounter : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtCounter = findViewById<Button>(R.id.textCounter)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(12)).get(MainViewModel::class.java)
        setText()
    }

    fun increment(v: View){
        mainViewModel.increment()
        setText()
    }

    fun setText(){
        txtCounter.text = mainViewModel.count.toString()
    }

}