package com.example.mvvmwithretrofitandroom.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvmwithretrofitandroom.models.Result

@Dao
interface QuoteDAO {

    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("Select * from quote")
    suspend fun  getQuotes() : List<Result>
}