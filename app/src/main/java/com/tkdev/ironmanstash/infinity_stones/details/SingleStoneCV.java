package com.tkdev.ironmanstash.infinity_stones.details;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkdev.ironmanstash.R;
import com.tkdev.ironmanstash.infinity_stones.database.StonesDbHelper;

import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.DETAIL_TABLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class SingleStoneCV extends Fragment {

    StonesDbHelper dbHelper;
    SQLiteDatabase database;
    Cursor cursor;
    protected TabLayout tabLayout;
    protected ViewPager viewPager;
    private SingleStonePagerAdapter pagerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_single_view, container, false);

        tabLayout = rootView.findViewById(R.id.tab_layout);
        viewPager = rootView.findViewById(R.id.stone_vp_pages);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dbHelper = new StonesDbHelper(getContext());
        database = dbHelper.getReadableDatabase();
        cursor = database.query(DETAIL_TABLE, null, null, null, null, null, null);

        pagerAdapter = new SingleStonePagerAdapter(getChildFragmentManager(), cursor);

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
}

