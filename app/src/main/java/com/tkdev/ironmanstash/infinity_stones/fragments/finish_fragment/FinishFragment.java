package com.tkdev.ironmanstash.infinity_stones.fragments.finish_fragment;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tkdev.ironmanstash.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinishFragment extends Fragment {

    private ImageView weLoveYou;
    private MediaPlayer mediaPlayer;

    public FinishFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_finish, container, false);
        weLoveYou = rootView.findViewById(R.id.love_you_3000);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bdaySong();

        weLoveYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
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

