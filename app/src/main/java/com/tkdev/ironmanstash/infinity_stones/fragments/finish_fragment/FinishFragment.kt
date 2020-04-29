package com.tkdev.ironmanstash.infinity_stones.fragments.finish_fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.tkdev.ironmanstash.R
import kotlinx.android.synthetic.main.fragment_finish.*
import kotlin.system.exitProcess

class FinishFragment : Fragment() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                     savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_finish, container, false)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        bdaySong()
        loveYouImage.setOnClickListener { exitProcess(0) }
    }

    private fun bdaySong() {
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.happy_bday)
        mediaPlayer?.start()
    }

    override fun onResume() {
        super.onResume()
//        if (mediaPlayer != null) {
//            mediaPlayer?.start()
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        if (mediaPlayer != null) {
//            mediaPlayer?.release()
//        }
//        mediaPlayer = null
    }
}