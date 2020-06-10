package com.tkdev.ironmanstash.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.data.StonesDatabase
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InfinityStoneViewModel(app: Application) : AndroidViewModel(app) {

    private val repository: InfinityStoneRepository

    val allWords: LiveData<List<InfinityStoneEntity>>

    init {
        val wordsDao = StonesDatabase.getDatabase(app).dao()
        repository = InfinityStoneRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(stone: InfinityStoneEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(stone)
    }
}
