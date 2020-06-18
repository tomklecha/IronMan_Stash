package com.tkdev.ironmanstash.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.databinding.FragmentMissionSingleBinding
import com.tkdev.ironmanstash.utils.COLUMN_INFO_ID
import com.tkdev.ironmanstash.utils.InjectorUtils
import com.tkdev.ironmanstash.viewmodels.SingleMissionViewModel
import kotlinx.android.synthetic.main.fragment_mission_single.*

class SingleMissionFragment : Fragment(R.layout.fragment_mission_single) {

    private val singleMissionViewModel: SingleMissionViewModel by viewModels {
        InjectorUtils.provideSingleMissionViewModelFactory(this.requireContext(), uid)
    }

    private var uid: Long = 0
//    private var name: String = ""
//    private var color: Int = 0
//    private var quest: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        uid = arguments?.getLong(COLUMN_INFO_ID) ?: throw IllegalStateException()
//        name = arguments?.getString(COLUMN_INFO_NAME) ?: throw IllegalStateException()
//        color = arguments?.getInt(COLUMN_INFO_COLOR) ?: throw IllegalStateException()
//        quest = arguments?.getInt(COLUMN_INFO_QUEST) ?: throw IllegalStateException()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMissionSingleBinding.inflate(inflater, container, false).apply {
            viewModel = singleMissionViewModel
            callback = object : MissionCallback{
                    override fun checkPassword() {
                        Toast.makeText(requireContext(), singleMissionViewModel.password.value.toString(), Toast.LENGTH_SHORT).show()
//                    root.passwordInputEditText.text.toString()
                        singleMissionViewModel.complete(uid)
                        activity?.onBackPressed()
                    }
                }
            }



        singleMissionViewModel.mission.observe(viewLifecycleOwner, Observer {
            stoneTitleTextView.text = it.name
            questTextView.text = resources.getText(it.quest)
            viewBackgroundColor(it.color)

        })

        return binding.root
    }

    private fun viewBackgroundColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view?.setBackgroundColor(resources.getColor(color, null))
        } else {
            view?.setBackgroundColor(resources.getColor(color))
        }
    }

    interface MissionCallback {
        fun checkPassword()
    }
}



