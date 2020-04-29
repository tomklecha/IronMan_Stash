package com.tkdev.ironmanstash.infinity_stones.fragments.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.infinity_stones.fragments.Operations
import kotlinx.android.synthetic.main.fragment_single_view.*

class SingleStoneViewPager : Fragment() {
    private lateinit var pagerAdapter: SingleStonePagerAdapter
    private var singleStoneList: List<SingleStone> = ArrayList()
    lateinit var operations: Operations

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_single_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        operations = activity?.baseContext?.let { Operations(it) }!!
        singleStoneList = operations.detailStoneList as List<SingleStone>
        pagerAdapter = SingleStonePagerAdapter(childFragmentManager, singleStoneList)
        stone_vp_pages.adapter = pagerAdapter
        stone_vp_pages.setPageTransformer(true, ViewPagerTransformer())
        tab_layout.setupWithViewPager(stone_vp_pages)
    }
}