package com.tkdev.ironmanstash.adapters


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tkdev.ironmanstash.data.InfinityStoneEntity
import com.tkdev.ironmanstash.ui.SingleMissionFragment
import com.tkdev.ironmanstash.utils.COLUMN_INFO_ID

class MissionAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private var missions = emptyList<InfinityStoneEntity>()


    override fun getItemCount(): Int = missions.size

    override fun createFragment(position: Int): Fragment {
        val bundle = Bundle()
        bundle.putSerializable(COLUMN_INFO_ID, missions[position].uid)
        val fragment = SingleMissionFragment()
        fragment.arguments = bundle
        return fragment
    }

    fun setStones(missions: List<InfinityStoneEntity>) {
        this.missions = missions
    }

}