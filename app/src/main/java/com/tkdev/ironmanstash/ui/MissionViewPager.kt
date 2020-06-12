package com.tkdev.ironmanstash.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.adapters.MissionAdapter
import com.tkdev.ironmanstash.utils.InjectorUtils
import com.tkdev.ironmanstash.viewmodels.InfinityStoneViewModel
import kotlinx.android.synthetic.main.fragment_mission_view.*

class MissionViewPager : FragmentActivity(R.layout.fragment_mission_view) {

    private val infinityStonesModel: InfinityStoneViewModel by viewModels {
        InjectorUtils.provideInfinityStoneViewModelFactory(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pagerAdapter = MissionAdapter(this)
        stone_vp_pages.adapter = pagerAdapter

        infinityStonesModel.allMissions.observe(this, Observer { stones ->
            stones?.let {
                pagerAdapter.setStones(it)
                attachTabLayout()
            }
        })
    }

    private fun attachTabLayout() {
        TabLayoutMediator(tab_layout, stone_vp_pages) { tab, position ->
            tab.text = (position + 1).toString()
        }.attach()
    }
}