package com.tkdev.ironmanstash.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.ui.SingleMissionFragment
import com.tkdev.ironmanstash.utils.COLUMN_INFO_COLOR
import com.tkdev.ironmanstash.utils.COLUMN_INFO_ID
import com.tkdev.ironmanstash.utils.COLUMN_INFO_NAME
import com.tkdev.ironmanstash.utils.COLUMN_INFO_QUEST

class MissionAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private var missions = emptyList<InfinityStoneEntity>()

    override fun getItemCount(): Int = missions.size

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putSerializable(COLUMN_INFO_ID, missions[position].uid)
        bundle.putSerializable(COLUMN_INFO_NAME, missions[position].name)
        bundle.putSerializable(COLUMN_INFO_COLOR, missions[position].color)
        bundle.putSerializable(COLUMN_INFO_QUEST, missions[position].quest)
        val fragment = SingleMissionFragment()
        fragment.arguments = bundle
        return fragment
    }

    fun setStones(missions: List<InfinityStoneEntity>) {
        this.missions = missions
        notifyDataSetChanged()
    }

}