package com.messer_amd.shoppinglistyandex.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MainDataBase : RoomDatabase(){

    abstract fun getDao(): Dao

    companion object{
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "shopping_list.db"
                ).build()
                instance
            }
        }
    }
}