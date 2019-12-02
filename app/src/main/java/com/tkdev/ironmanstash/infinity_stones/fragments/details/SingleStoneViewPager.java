package com.tkdev.ironmanstash.infinity_stones.fragments.details;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkdev.ironmanstash.R;
import com.tkdev.ironmanstash.infinity_stones.fragments.Operations;

import java.util.ArrayList;
import java.util.List;


public class SingleStoneViewPager extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    SingleStonePagerAdapter pagerAdapter;
    List<SingleStone> singleStoneList = new ArrayList<>();
    Operations operations;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_single_view, container, false);

        tabLayout = rootView.findViewById(R.id.tab_layout);
        viewPager = rootView.findViewById(R.id.stone_vp_pages);
        viewPager.setPageTransformer(true, new ViewPagerTransformer());
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        operations = Operations.get(getContext());
        singleStoneList = operations.getDetailStoneList();

        pagerAdapter = new SingleStonePagerAdapter(getChildFragmentManager(), singleStoneList);

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

}

