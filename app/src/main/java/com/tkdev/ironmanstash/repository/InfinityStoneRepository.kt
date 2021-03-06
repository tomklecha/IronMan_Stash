package com.tkdev.ironmanstash.repository

import androidx.lifecycle.LiveData
import com.tkdev.ironmanstash.data.InfinityStoneDao
import com.tkdev.ironmanstash.data.InfinityStoneEntity

class InfinityStoneRepository(private val dao: InfinityStoneDao) {

    val allStones: LiveData<List<InfinityStoneEntity>> = dao.getInfinityStones()

    companion object {

        @Volatile
        private var instance: InfinityStoneRepository? = null

        fun getInstance(dao: InfinityStoneDao) =
                instance ?: synchronized(this) {
                    instance ?: InfinityStoneRepository(dao).also { instance = it }
                }
    }
}
