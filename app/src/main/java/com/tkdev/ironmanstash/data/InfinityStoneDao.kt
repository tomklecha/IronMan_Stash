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

    @Query("SELECT * from ise WHERE isVisible = 0")
    fun getMissingInfinityStones(): LiveData<List<InfinityStoneEntity>>

    @Query("SELECT * from ise WHERE uid = :uid")
    fun getMission(uid: Long): LiveData<InfinityStoneEntity>

    @Query("SELECT password from ise WHERE uid = :uid")
    suspend fun getPassword(uid: Long): Int

    @Query("UPDATE ISE SET isVisible = 1 WHERE uid = :uid")
    fun complete(uid: Long)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(stone: InfinityStoneEntity)

    @Query("DELETE FROM ise")
    fun deleteAll()
}