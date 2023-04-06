package com.messer_amd.shoppinglistyandex.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.messer_amd.shoppinglistyandex.entities.LibraryItem
import com.messer_amd.shoppinglistyandex.entities.ShoppingListItem
import com.messer_amd.shoppinglistyandex.entities.ShoppingListNames

@Database(entities = [
    LibraryItem::class,
    ShoppingListItem::class,
    ShoppingListNames::class],
    version = 1,
    exportSchema = true//,
    //autoMigrations = [AutoMigration(from = 1, to = 2)]
)

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