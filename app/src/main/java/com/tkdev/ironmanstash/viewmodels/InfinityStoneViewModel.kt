package com.tkdev.ironmanstash.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import java.util.concurrent.Executors

class InfinityStoneViewModel(
        private val repository: InfinityStoneRepository
) : ViewModel() {

    val allStones: LiveData<List<InfinityStoneEntity>> = repository.allStones

    val allMissions: LiveData<List<InfinityStoneEntity>> = repository.allMissions

    fun getMission(uid: Long): LiveData<InfinityStoneEntity> = repository.getMission(uid)

    fun complete(uid: Long) = Executors.newSingleThreadExecutor().execute {repository.complete(uid)  }
}
