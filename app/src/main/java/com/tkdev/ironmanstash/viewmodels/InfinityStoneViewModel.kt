package com.tkdev.ironmanstash.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.repository.InfinityStoneRepository

class InfinityStoneViewModel(
        private val repository: InfinityStoneRepository
) : ViewModel() {

    val allStones: LiveData<List<InfinityStoneEntity>> = repository.allStones

}
