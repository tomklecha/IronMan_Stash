package com.tkdev.ironmanstash.infinity_stones.fragments

import InfinityFragment
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.tkdev.ironmanstash.R
import kotlinx.android.synthetic.main.fragment_stark.*

class StarkFragment : Fragment() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_stark, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        scrollView.alpha = 0.0f
        scrollView.setBackgroundColor(resources.getColor(R.color.scrollBackground))
        agreeButton.alpha = 0.0f
        helmetView.setImageResource(R.drawable.ironman_helmet_r)
        helmetView.alpha = 0.2f
        helmetView.setOnClickListener {
            helmetView.setOnClickListener(null)
            stark_container.setBackgroundColor(-0xddddde)
            helmetView.animate().alpha(1.0f).duration = 1500
            scrollView.animate().alpha(1.0f).setDuration(3000).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    val scrollAnimator = ObjectAnimator.ofInt(scrollView, "scrollY", scrollView.getChildAt(0).height - scrollView.height)
                    scrollAnimator.duration = 30000
                    scrollAnimator.interpolator = LinearInterpolator()
                    scrollAnimator.start()
                    scrollAnimator.addListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            agreeButton.animate().alpha(1.0f).duration = 5000
                        }
                    })
                }
            })
        }
        agreeButton.setOnClickListener {
            parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, InfinityFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit()
            mediaPlayer?.release()
        }
    }

    private fun backgroundSong() {
        mediaPlayer = MediaPlayer.create(context, R.raw.endgame)
        mediaPlayer?.seekTo(119700)
        mediaPlayer?.start()
    }

    override fun onResume() {
        super.onResume()
//       Runnable {  backgroundSong() }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.pause()
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
    }
}