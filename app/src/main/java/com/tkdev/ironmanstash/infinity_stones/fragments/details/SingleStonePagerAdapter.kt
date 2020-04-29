package com.tkdev.ironmanstash.infinity_stones.fragments.details

import SingleStoneFragmentDetail
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class SingleStonePagerAdapter(fm: FragmentManager, private val singleStoneList: List<SingleStone>) : FragmentStatePagerAdapter(fm) {
    override fun getItem(posInList: Int): Fragment {
        val stone = singleStoneList[posInList]
        return SingleStoneFragmentDetail.newInstance(
                stone.name,
                stone.color,
                stone.quest,
                stone.password
        )
    }

    override fun getCount(): Int {
        return singleStoneList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return (position + 1).toString()
    }

}