package com.tkdev.ironmanstash.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class InfinityStoneViewModel(
        private val repository: InfinityStoneRepository
) : ViewModel() {

    val allStones: LiveData<List<InfinityStoneEntity>> = repository.allStones

    val allMissions: LiveData<List<InfinityStoneEntity>> = repository.allMissions

    fun complete(uid: Long) = viewModelScope.launch(Dispatchers.IO) { repository.complete(uid) }
}
