package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    //Return type is set to the DAO object
    abstract fun contactDao() : ContactDAO

    //Creating a singleton class for creating an instance of our database
    companion object{
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase{
            if(INSTANCE == null){
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java,

                        "contactDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}