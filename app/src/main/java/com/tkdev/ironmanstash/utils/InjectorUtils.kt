package com.tkdev.ironmanstash.utils

import android.content.Context
import com.tkdev.ironmanstash.data.StonesDatabase
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import com.tkdev.ironmanstash.viewmodels.InfinityStoneViewModelFactory

object InjectorUtils {

    private fun getInfinityStoneRepository(context: Context): InfinityStoneRepository {
        return InfinityStoneRepository.getInstance(
                StonesDatabase.getDatabase(context.applicationContext).dao())
    }


    fun provideInfinityStoneViewModelFactory(context: Context): InfinityStoneViewModelFactory {
        val repository = getInfinityStoneRepository(context)
        return InfinityStoneViewModelFactory(repository)
    }

}
