package com.tkdev.ironmanstash.infinity_stones.fragments.finish_fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkdev.ironmanstash.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinishFragment extends Fragment {

    private MediaPlayer mediaPlayer;

    public FinishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bdaySong();
    }

    private void bdaySong() {
        mediaPlayer = MediaPlayer.create(getContext(), R.raw.happy_bday);
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
    public void onDestroyView() {
        super.onDestroyView();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = null;

    }
}

