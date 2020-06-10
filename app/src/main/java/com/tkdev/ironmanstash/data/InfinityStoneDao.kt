package com.tkdev.ironmanstash.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface InfinityStoneDao {
    @Query("SELECT * from ise")
    fun getInfinityStones(): LiveData<List<InfinityStoneEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(stone: InfinityStoneEntity)

    @Query("DELETE FROM ise")
    fun deleteAll()
}