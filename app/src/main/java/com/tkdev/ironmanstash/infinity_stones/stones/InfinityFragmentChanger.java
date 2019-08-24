package com.tkdev.ironmanstash.infinity_stones.stones;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tkdev.ironmanstash.R;
import com.tkdev.ironmanstash.infinity_stones.details.SingleStoneCV;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfinityFragmentChanger extends Fragment {

    public static final int STONE_INVISIBLE = View.INVISIBLE;
    public static final int STONE_VISIBLE = View.VISIBLE;

    private InfinityAdapter infinityAdapter;
    private List<InfinityStone> infinityStones = new ArrayList<>();
    private InfinityStonesOperations operations;
    private RecyclerView recyclerView;
    private Button gatherButton;
    private TextView iftext;

    private String name;

    public InfinityFragmentChanger() {
        // Required empty public constructor
    }

    public static InfinityFragmentChanger newInstance(String name){

        Bundle bundle = new Bundle();
        bundle.putSerializable("NAME", name);

        InfinityFragmentChanger fragment = new InfinityFragmentChanger();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {


//        name = (String) getArguments().getSerializable("NAME");



        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_infinity, container, false);

        iftext = rootView.findViewById(R.id.infinity_stones_title_page);
        gatherButton = rootView.findViewById(R.id.gather_button);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);




        int i = 1+1;

        infinityAdapter = new InfinityAdapter(getContext(), infinityStones);
        recyclerView.setAdapter(infinityAdapter);

        Toast.makeText(getContext(), "Password correct, unlocked " + name + "In fragment Changer", Toast.LENGTH_SHORT).show();



        gatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.infinity_fragment_layout, new SingleStoneCV(), "frag3")
                        .addToBackStack("frag3")
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
        });


    }
 }


