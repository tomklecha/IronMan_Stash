package com.tkdev.ironmanstash.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.data.StonesDatabase
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import java.lang.reflect.Executable
import java.util.concurrent.Executors

class MissionViewModel(app: Application) : AndroidViewModel(app) {

    private val repository: InfinityStoneRepository

    val allMissions: LiveData<List<InfinityStoneEntity>>

    init {
        val wordsDao = StonesDatabase.getDatabase(app).dao()
        repository = InfinityStoneRepository(wordsDao)
        allMissions = repository.allMissions
    }

    fun getMission(uid: Long): LiveData<InfinityStoneEntity> = repository.getMission(uid)

    fun complete(uid: Long) = Executors.newSingleThreadExecutor().execute {repository.complete(uid)  }

}

