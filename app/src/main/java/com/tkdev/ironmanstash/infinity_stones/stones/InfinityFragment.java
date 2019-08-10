package com.tkdev.ironmanstash.infinity_stones.stones;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkdev.ironmanstash.R;
import com.tkdev.ironmanstash.infinity_stones.database.StonesDbHelper;

import java.util.ArrayList;

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

    private RecyclerView recyclerView;
    private InfinityCursorAdapter infinityAdapter;



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

        dbHelper = new StonesDbHelper(getContext());
        database = dbHelper.getReadableDatabase();
        cursor = database.query(IF_TABLE, null, null, null, null, null, null);


        infinityAdapter = new InfinityCursorAdapter(getContext(), cursor);

        recyclerView.setAdapter(infinityAdapter);

        }

    }


