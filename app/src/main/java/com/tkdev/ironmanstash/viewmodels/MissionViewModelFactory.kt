package com.tkdev.ironmanstash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import com.tkdev.ironmanstash.repository.MissionRepository

class MissionViewModelFactory(
        private val repository: MissionRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MissionViewModel(repository) as T
    }
}
