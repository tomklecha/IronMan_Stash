package com.tkdev.ironmanstash.infinity_stones.stones;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tkdev.ironmanstash.R;
import com.tkdev.ironmanstash.infinity_stones.database.StonesDbHelper;
import com.tkdev.ironmanstash.infinity_stones.details.SingleStoneCV;

import java.util.ArrayList;
import java.util.List;

import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.IF_TABLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfinityFragment extends Fragment {

    public static final int STONE_INVISIBLE = View.INVISIBLE;
    public static final int STONE_VISIBLE = View.VISIBLE;

    StonesDbHelper dbHelper;
    SQLiteDatabase database;
    Cursor cursor;
    private InfinityCursorAdapter infinityCursorAdapter;


    private InfinityAdapter infinityAdapter;
    private List<InfinityStone> infinityStones;
    private InfinityStonesOperations operations;
    private RecyclerView recyclerView;
    private Button gatherButton;



    public InfinityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_infinity, container, false);

        gatherButton = rootView.findViewById(R.id.gather_button);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dbHelper = new StonesDbHelper(getContext());
        database = dbHelper.getReadableDatabase();
        cursor = database.query(IF_TABLE, null, null, null, null, null, null);



        infinityCursorAdapter = new InfinityCursorAdapter(getContext(), cursor);


        recyclerView.setAdapter(infinityCursorAdapter);

        gatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String i = String.valueOf(getFragmentManager().getBackStackEntryCount());
//                Toast.makeText(getContext(), i, Toast.LENGTH_SHORT).show();

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.infinity_fragment_layout, new SingleStoneCV(), "frag3" )
                        .addToBackStack("frag3")
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
            }
        });


        }



    }


