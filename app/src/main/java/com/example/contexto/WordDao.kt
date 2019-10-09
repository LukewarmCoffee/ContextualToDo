package com.example.contexto

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordDao {
    @Query("SELECT * from do_table ORDER BY title ASC")
    fun getAllWords(): LiveData<List<DoContext>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(doContext: DoContext)

    @Query("DELETE FROM do_table")
    suspend fun deleteAll()
}