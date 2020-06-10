package com.tkdev.ironmanstash.repository

import androidx.lifecycle.LiveData
import com.tkdev.ironmanstash.data.InfinityStoneDao
import com.tkdev.ironmanstash.data.InfinityStoneEntity

class InfinityStoneRepository (private val dao: InfinityStoneDao) {

    val allWords: LiveData<List<InfinityStoneEntity>> = dao.getInfinityStones()

    suspend fun insert(stone: InfinityStoneEntity) {
        dao.insert(stone)
    }
}
