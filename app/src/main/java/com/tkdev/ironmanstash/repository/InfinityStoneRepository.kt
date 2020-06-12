package com.tkdev.ironmanstash.repository

import androidx.lifecycle.LiveData
import com.tkdev.ironmanstash.data.InfinityStoneDao
import com.tkdev.ironmanstash.data.InfinityStoneEntity

class InfinityStoneRepository(private val dao: InfinityStoneDao) {

    val allStones: LiveData<List<InfinityStoneEntity>> = dao.getInfinityStones()

    val allMissions: LiveData<List<InfinityStoneEntity>> = dao.getMissingInfinityStones()

    fun getMission(uid: Long): LiveData<InfinityStoneEntity> {
        return dao.getMission(uid)
    }

   fun complete(uid: Long) = dao.complete(uid)

}
