package com.tkdev.ironmanstash.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.adapters.InfinityStonesAdapter
import com.tkdev.ironmanstash.utils.InjectorUtils
import com.tkdev.ironmanstash.viewmodels.InfinityStoneViewModel
import kotlinx.android.synthetic.main.fragment_infinity.*

class InfinityFragment : Fragment() {

    private val infinityStonesModel: InfinityStoneViewModel by viewModels {
        InjectorUtils.provideInfinityStoneViewModelFactory(this.requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_infinity, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapterStones = context?.let { InfinityStonesAdapter(it) }
        recycler_view.apply {
            adapter = adapterStones
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }

        infinityStonesModel.allStones.observe(viewLifecycleOwner, Observer { stones ->
            stones?.let { adapterStones?.setStones(it) }
        })

        gatherButton.setOnClickListener {
            activity?.let { startActivity(Intent(it, MissionViewPager::class.java)) }
        }
    }

}


