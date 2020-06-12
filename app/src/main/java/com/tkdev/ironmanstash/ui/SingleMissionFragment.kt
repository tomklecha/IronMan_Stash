package com.tkdev.ironmanstash.ui

import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.utils.COLUMN_INFO_ID
import com.tkdev.ironmanstash.viewmodels.MissionViewModel
import kotlinx.android.synthetic.main.fragment_stone_detail.*

class SingleMissionFragment : Fragment(R.layout.fragment_stone_detail) {

    private lateinit var missionViewModel: MissionViewModel
    private var uid: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        uid = arguments?.getLong(COLUMN_INFO_ID)!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        missionViewModel = ViewModelProvider(this).get(MissionViewModel::class.java)
        missionViewModel.getMission(uid).observe(viewLifecycleOwner, Observer { stone ->
            stone?.let {
                stoneTitleTextView.text = it.name
                questTextView.text = resources.getText(it.quest)
                viewBackgroundColor(it.color)
            }
        })

        confirmButton.setOnClickListener {
            missionViewModel.complete(uid)
            activity?.onBackPressed()
        }
    }


    private fun viewBackgroundColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view?.setBackgroundColor(resources.getColor(color, null))
        } else {
            view?.setBackgroundColor(resources.getColor(color))
        }
    }
}


