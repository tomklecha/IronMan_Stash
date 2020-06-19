package com.tkdev.ironmanstash.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import com.tkdev.ironmanstash.repository.MissionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class MissionViewModel(
        private val repository: MissionRepository
) : ViewModel() {

    val allMissions: LiveData<List<InfinityStoneEntity>> = repository.allMissions

}
