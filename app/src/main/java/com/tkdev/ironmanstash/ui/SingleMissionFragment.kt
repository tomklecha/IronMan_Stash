package com.tkdev.ironmanstash.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tkdev.ironmanstash.R
import com.tkdev.ironmanstash.utils.COLUMN_INFO_COLOR
import com.tkdev.ironmanstash.utils.COLUMN_INFO_NAME
import com.tkdev.ironmanstash.utils.COLUMN_INFO_PASSWORD
import com.tkdev.ironmanstash.utils.COLUMN_INFO_QUEST
import kotlinx.android.synthetic.main.fragment_stone_detail.*

class SingleMissionFragment : Fragment() {
    private var name: String? = null
    private var color = 0

    //    private int converter = 0x00222222;
    private val converter = 0
    private var quest = 0
    private var passwordInput: String? = null
    private var passwordExpected = 0

   fun newInstance(name: String, color: Int, quest: Int, password: Int): SingleMissionFragment {
        val bundle = Bundle()
        bundle.putSerializable(COLUMN_INFO_NAME, name)
        bundle.putSerializable(COLUMN_INFO_COLOR, color)
        bundle.putSerializable(COLUMN_INFO_QUEST, quest)
        bundle.putSerializable(COLUMN_INFO_PASSWORD, password)
        val fragment = SingleMissionFragment()
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null){
        name = arguments!!.getString(COLUMN_INFO_NAME)
        color = arguments!!.getInt(COLUMN_INFO_COLOR)
        quest = arguments!!.getInt(COLUMN_INFO_QUEST)
        passwordExpected = arguments!!.getInt(COLUMN_INFO_PASSWORD)
    }

}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_stone_detail,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        stoneTitleTextView.text = name
        
    }
}


