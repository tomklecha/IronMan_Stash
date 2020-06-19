package com.tkdev.ironmanstash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import com.tkdev.ironmanstash.repository.MissionRepository
import com.tkdev.ironmanstash.repository.SingleMissionRepository

class SingleMissionViewModelFactory(
        private val repository: SingleMissionRepository,
        private val uid: Long
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SingleMissionViewModel(repository, uid) as T
    }
}
