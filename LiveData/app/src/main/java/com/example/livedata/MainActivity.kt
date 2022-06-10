package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    private  val factsTextView : TextView
    get() = findViewById(R.id.factTextView)

    private  val btnUpdate : Button
    get() = findViewById(R.id.btnUpdate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.factsLiveData.observe(this, Observer {
            /* Any changes happening to the LiveData (factsLiveData in our case) will get
            notified to MainActivity and then the code written in this segment
            will be executed */
            factsTextView.text = it

        })

        btnUpdate.setOnClickListener{
            mainViewModel.updateLiveData()
        }

    }
}