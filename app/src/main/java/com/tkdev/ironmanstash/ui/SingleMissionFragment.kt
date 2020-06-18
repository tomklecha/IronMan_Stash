package com.tkdev.ironmanstash.ui

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.utils.*
import com.tkdev.ironmanstash.viewmodels.MissionViewModel
import kotlinx.android.synthetic.main.fragment_stone_detail.*

class SingleMissionFragment : Fragment(R.layout.fragment_stone_detail) {

    private val infinityStonesModel: MissionViewModel by viewModels {
        InjectorUtils.provideMissionViewModelFactory(this.requireContext())
    }

    private var uid: Long = 0
    private var name: String = ""
    private var color: Int = 0
    private var quest: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        uid = arguments?.getLong(COLUMN_INFO_ID) ?: throw IllegalStateException()
        name = arguments?.getString(COLUMN_INFO_NAME) ?: throw IllegalStateException()
        color = arguments?.getInt(COLUMN_INFO_COLOR) ?: throw IllegalStateException()
        quest = arguments?.getInt(COLUMN_INFO_QUEST) ?: throw IllegalStateException()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        stoneTitleTextView.text = name
        questTextView.text = resources.getText(quest)
        viewBackgroundColor(color)

        confirmButton.setOnClickListener {
            infinityStonesModel.complete(uid)
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



