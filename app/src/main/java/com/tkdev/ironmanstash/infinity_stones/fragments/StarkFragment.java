package com.tkdev.ironmanstash.infinity_stones.fragments;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.tkdev.ironmanstash.R;
import com.tkdev.ironmanstash.infinity_stones.fragments.allstones.InfinityFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class StarkFragment extends Fragment {


    private ScrollView scrollView;
    private ImageView helmetView;
    private Button agreeButton;
    private MediaPlayer mediaPlayer;

    public StarkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stark, container, false);


        helmetView = rootView.findViewById(R.id.imageView);
        scrollView = rootView.findViewById(R.id.scroll_view);
        agreeButton = rootView.findViewById(R.id.agree_button);

        scrollView.setAlpha(0.0f);
        scrollView.setBackgroundColor(getResources().getColor(R.color.scrollBackground));
        agreeButton.setAlpha(0.0f);
        helmetView.setImageResource(R.drawable.ironman_helmet_r);
        helmetView.setAlpha(0.2f);


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        backgroundSong();

        helmetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helmetView.setOnClickListener(null);
                getView().setBackgroundColor(0xFF222222);
                helmetView.animate().alpha(1.0f).setDuration(1500);
                scrollView.animate().alpha(1.0f).setDuration(3000).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ObjectAnimator scrollAnimator = ObjectAnimator.ofInt(scrollView, "scrollY", scrollView.getChildAt(0).getHeight() - scrollView.getHeight());
                        scrollAnimator.setDuration(30000);
                        scrollAnimator.setInterpolator(new LinearInterpolator());
                        scrollAnimator.start();
                        scrollAnimator.addListener(new AnimatorListenerAdapter() {


                            @Override
                            public void onAnimationEnd(Animator animation) {
                                agreeButton.animate().alpha(1.0f).setDuration(5000);
                            }
                        });
                    }
                });

            }
        });


        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_container, new InfinityFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                }
                mediaPlayer = null;
            }
        });
    }

    private void backgroundSong() {
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.endgame);
        mediaPlayer.seekTo(119700);
        mediaPlayer.start();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }

    }

    @Override
    public void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = null;

    }
}
