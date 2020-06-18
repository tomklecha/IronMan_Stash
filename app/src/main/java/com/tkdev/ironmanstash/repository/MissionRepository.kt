package com.tkdev.ironmanstash.repository

import androidx.lifecycle.LiveData
import com.tkdev.ironmanstash.data.InfinityStoneDao
import com.tkdev.ironmanstash.data.InfinityStoneEntity

class MissionRepository(private val dao: InfinityStoneDao) {

    val allMissions: LiveData<List<InfinityStoneEntity>> = dao.getMissingInfinityStones()

    fun complete(uid: Long) = dao.complete(uid)

    companion object {

        @Volatile
        private var instance: MissionRepository? = null

        fun getInstance(dao: InfinityStoneDao) =
                instance ?: synchronized(this) {
                    instance ?: MissionRepository(dao).also { instance = it }
                }
    }
}
