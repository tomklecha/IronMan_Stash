package com.tkdev.ironmanstash.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tkdev.ironmanstash.data.InfinityStoneEntity

@Dao
interface InfinityStoneDao {
    @Query("SELECT * from ise")
    fun getInfinityStones(): LiveData<List<InfinityStoneEntity>>

    @Query("SELECT * from ise WHERE isVisible = 0")
    fun getMissingInfinityStones(): LiveData<List<InfinityStoneEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(stone: InfinityStoneEntity)

    @Query("DELETE FROM ise")
    fun deleteAll()
}