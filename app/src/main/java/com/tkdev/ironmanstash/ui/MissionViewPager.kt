package com.tkdev.ironmanstash.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.adapters.MissionAdapter
import com.tkdev.ironmanstash.viewmodels.MissionViewModel
import kotlinx.android.synthetic.main.fragment_mission_view.*

class MissionViewPager : FragmentActivity(R.layout.fragment_mission_view) {

    private lateinit var missionViewModel: MissionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pagerAdapter = MissionAdapter(this)
        stone_vp_pages.adapter = pagerAdapter

        missionViewModel = ViewModelProvider(this).get(MissionViewModel::class.java)
        missionViewModel.allMissions.observe(this, Observer { stones ->
            stones?.let {
                pagerAdapter.setStones(it)
                TabLayoutMediator(tab_layout, stone_vp_pages) { tab, position ->
                    tab.text = (position + 1).toString()
                }.attach()
            }
        })
    }
}