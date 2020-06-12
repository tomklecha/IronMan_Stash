package com.tkdev.ironmanstash.utils

import android.content.Context
import androidx.fragment.app.Fragment
import com.tkdev.ironmanstash.data.StonesDatabase
import com.tkdev.ironmanstash.repository.InfinityStoneRepository
import com.tkdev.ironmanstash.viewmodels.InfinityStoneViewModelFactory

object InjectorUtils {

    private fun getInfinityStoneRepository(context: Context): InfinityStoneRepository {
        return InfinityStoneRepository.getInstance(
                StonesDatabase.getDatabase(context.applicationContext).dao())
    }


    fun provideInfinityStoneViewModelFactory(fragment: Fragment): InfinityStoneViewModelFactory {
        val repository = getInfinityStoneRepository(fragment.requireContext())
        return InfinityStoneViewModelFactory(repository)
    }

}
