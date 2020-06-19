package com.tkdev.ironmanstash.repository

import androidx.lifecycle.LiveData
import com.tkdev.ironmanstash.data.InfinityStoneDao
import com.tkdev.ironmanstash.data.InfinityStoneEntity

class SingleMissionRepository(private val dao: InfinityStoneDao) {

    fun mission(uid: Long): LiveData<InfinityStoneEntity> = dao.getMission(uid)

    suspend fun getPassword(uid: Long): Int = dao.getPassword(uid)

    fun complete(uid: Long) = dao.complete(uid)

    companion object {

        @Volatile
        private var instance: SingleMissionRepository? = null

        fun getInstance(dao: InfinityStoneDao) =
                instance ?: synchronized(this) {
                    instance ?: SingleMissionRepository(dao).also { instance = it }
                }
    }
}
