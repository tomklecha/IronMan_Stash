package com.tkdev.ironmanstash.utils

import android.content.Context
import com.tkdev.ironmanstash.data.StonesDatabase
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import com.tkdev.ironmanstash.repository.MissionRepository
import com.tkdev.ironmanstash.viewmodels.InfinityStoneViewModelFactory
import com.tkdev.ironmanstash.viewmodels.MissionViewModelFactory

object InjectorUtils {

    private fun getInfinityStoneRepository(context: Context): InfinityStoneRepository {
        return InfinityStoneRepository.getInstance(
                StonesDatabase.getDatabase(context.applicationContext).dao())
    }


    fun provideInfinityStoneViewModelFactory(context: Context): InfinityStoneViewModelFactory {
        val repository = getInfinityStoneRepository(context)
        return InfinityStoneViewModelFactory(repository)
    }

    private fun getMissionRepository(context: Context): MissionRepository {
        return MissionRepository.getInstance(
                StonesDatabase.getDatabase(context.applicationContext).dao())
    }

    fun provideMissionViewModelFactory(context: Context): MissionViewModelFactory {
        val repository = getMissionRepository(context)
        return MissionViewModelFactory(repository)
    }
}
