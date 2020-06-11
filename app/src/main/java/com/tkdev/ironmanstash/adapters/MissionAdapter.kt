package com.tkdev.ironmanstash.adapters


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.ui.SingleMissionFragment

class MissionAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private var missions = emptyList<InfinityStoneEntity>()

    override fun getItemCount(): Int = missions.size

    override fun createFragment(position: Int): Fragment {
        return SingleMissionFragment().newInstance(
                missions[position].name,
                missions[position].color,
                missions[position].quest,
                missions[position].password)
    }

    fun setStones(missions: List<InfinityStoneEntity>) {
        this.missions = missions
    }

}