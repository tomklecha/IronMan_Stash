package com.tkdev.ironmanstash.infinity_stones.fragments.allstones;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tkdev.ironmanstash.R;
import com.tkdev.ironmanstash.infinity_stones.fragments.Operations;
import com.tkdev.ironmanstash.infinity_stones.fragments.details.SingleStoneViewPager;
import com.tkdev.ironmanstash.infinity_stones.fragments.finish_fragment.FinishFragment;

import java.util.ArrayList;
import java.util.List;


public class InfinityFragment extends Fragment {

    public static final String FRAGMENT_TAG = "fragment";
    public static final String STONE_NAME = "stoneNameNewInstance";

    private Operations operations;
    private InfinityAdapter infinityAdapter;
    private ImageView gauntletImage;
    private TextView titleView;
    private List<InfinityStone> infinityStones = new ArrayList<>();
    private RecyclerView recyclerView;
    private Button gatherButton;
    private Bundle arguments;
    private String stoneNameNewInstance;
    private MediaPlayer mediaPlayer;

    public InfinityFragment() {
    }

    public static InfinityFragment newInstance(String name) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(STONE_NAME, name);

        InfinityFragment fragment = new InfinityFragment();
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        arguments = getArguments();
        if (arguments != null) {
            stoneNameNewInstance = (String) getArguments().getSerializable(STONE_NAME);
            operations = Operations.get(getContext());
            operations.updateStones(stoneNameNewInstance);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_infinity, container, false);

        titleView = rootView.findViewById(R.id.infinity_stones_title_page);
        gauntletImage = rootView.findViewById(R.id.infinity_gauntlet);
        gauntletImage.setVisibility(View.INVISIBLE);
        gatherButton = rootView.findViewById(R.id.gather_button);
        recyclerView = rootView.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        createViews();
        setVisibility();


        gatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_container, new SingleStoneViewPager(), FRAGMENT_TAG)
                        .addToBackStack(FRAGMENT_TAG)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();


            }
        });

        gauntletImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer = MediaPlayer.create(getContext(), R.raw.thanos_snap_sound_effect);
                mediaPlayer.seekTo(800);
                mediaPlayer.start();
                disappear();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                        }
                        mediaPlayer = null;

                    }
                });
                gauntletImage.setOnClickListener(null);
            }
        });


    }

    private void disappear() {
        long timer = 5000;
        titleView.animate().alpha(0.0f).setDuration(timer);
        recyclerView.animate().alpha(0.0f).setDuration(timer);
        gauntletImage.animate().
                alpha(0.0f)
                .setDuration(timer)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.infinity_fragment_container, new FinishFragment())
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .commit();
                    }
                });
    }

    private void createViews() {
        if (arguments == null) {
            operations = Operations.get(getContext());
            recyclerViews();
        } else {
            recyclerViews();
        }
    }

    private void recyclerViews() {
        infinityStones = operations.getInfinityStoneList();
        infinityAdapter = new InfinityAdapter(getContext(), infinityStones);
        recyclerView.setAdapter(infinityAdapter);
    }

    private void setVisibility() {

        if (operations.gauntletVisibility()) {
            gauntletImage.setVisibility(View.VISIBLE);
            gatherButton.setVisibility(View.GONE);
        }
    }


}


