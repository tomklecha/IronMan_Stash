package com.tkdev.ironmanstash.infinity_stones;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkdev.ironmanstash.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfinityFragment extends Fragment {

    public static final int STONE_INVISIBLE = View.INVISIBLE;
    public static final int STONE_VISIBLE = View.VISIBLE;

    private RecyclerView recyclerView;
    private InfinityAdapter infinityAdapter;



    public InfinityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_infinity, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<InfinityStones> infinityStones = new ArrayList<>();
        infinityStones.add(new InfinityStones(android.R.drawable.ic_lock_lock, "Power Stone", STONE_INVISIBLE));
        infinityStones.add(new InfinityStones(android.R.drawable.ic_menu_report_image, "Time Stone",STONE_VISIBLE));
        infinityStones.add(new InfinityStones(android.R.drawable.sym_call_missed, "Soul Stone", STONE_INVISIBLE));
        infinityStones.add(new InfinityStones(android.R.drawable.arrow_down_float, "Reality Stone", STONE_INVISIBLE));
        infinityStones.add(new InfinityStones(android.R.drawable.arrow_up_float, "Mind Stone", STONE_INVISIBLE));
        infinityStones.add(new InfinityStones(android.R.drawable.dialog_frame, "Space Stone", STONE_INVISIBLE));


        infinityAdapter = new InfinityAdapter(getContext(), infinityStones);

        recyclerView.setAdapter(infinityAdapter);

        }
    }

