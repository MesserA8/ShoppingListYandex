package com.messer_amd.shoppinglistyandex.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.messer_amd.shoppinglistyandex.entities.LibraryItem
import com.messer_amd.shoppinglistyandex.entities.ShoppingListItem
import com.messer_amd.shoppinglistyandex.entities.ShoppingListNames
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Query("SELECT * FROM shopping_list_names")
    fun getAllShopListNames(): Flow<List<ShoppingListNames>>
    @Query("SELECT * FROM shop_list_item WHERE listId LIKE :listId")
    fun getAllShopListItems(listId: Int): Flow<List<ShoppingListItem>>
    @Query("SELECT * FROM library WHERE name LIKE :name")
    suspend fun getAllLibraryItems(name: String): List<LibraryItem>
    @Query("DELETE FROM shopping_list_names WHERE id IS :id")
    suspend fun deleteShopListName(id: Int)
    @Query("DELETE FROM shop_list_item WHERE listId LIKE :listId")
    suspend fun deleteShopItemsByListId(listId: Int)
    @Query("DELETE FROM library WHERE id IS :id")
    suspend fun deleteLibraryItem(id: Int)
    @Insert
    suspend fun insertShopListName(nameItem: ShoppingListNames)
    @Insert
    suspend fun insertItem(shopListItem: ShoppingListItem)
    @Insert
    suspend fun insertLibraryItem(libraryItem: LibraryItem)
    @Update
    suspend fun updateLibraryItem(item: LibraryItem)
    @Update
    suspend fun updateListItem(item: ShoppingListItem)
    @Update
    suspend fun updateListName(shopListNameItem: ShoppingListItem)
}