package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDatabase : RoomDatabase() {
    //Return type is set to the DAO object
    abstract fun contactDao(): ContactDAO

    //Creating a singleton class for creating an instance of our database
    companion object {

        //Migration Object
        private val migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("Alter table contact add column isActive Integer not NULL default(1)")
            }
        }


        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                                context.applicationContext,
                                ContactDatabase::class.java,
                            "contactDB")
                                .addMigrations(migration_1_2)
                                .build()
                }
            }
            return INSTANCE!!
        }
    }
}