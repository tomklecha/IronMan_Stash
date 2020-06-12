package com.tkdev.ironmanstash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tkdev.ironmanstash.repository.InfinityStoneRepository

class InfinityStoneViewModelFactory(
        private val repository: InfinityStoneRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InfinityStoneViewModel(repository) as T
    }
}
