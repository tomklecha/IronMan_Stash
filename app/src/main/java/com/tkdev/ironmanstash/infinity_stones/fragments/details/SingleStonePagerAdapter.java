package com.tkdev.ironmanstash.infinity_stones.fragments.details;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class SingleStonePagerAdapter extends FragmentStatePagerAdapter {


    private List<SingleStone> singleStoneList;

    public SingleStonePagerAdapter(FragmentManager fm, List<SingleStone> singleStoneList) {
        super(fm);
        this.singleStoneList = singleStoneList;
    }


    @Override
    public Fragment getItem(int posInList) {

        SingleStone stone = singleStoneList.get(posInList);

        return SingleStoneFragmentDetail.newInstance(
                stone.getName(),
                stone.getColor(),
                stone.getQuest(),
                stone.getPassword()
        );
    }

    @Override
    public int getCount() {
        return singleStoneList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(position + 1);

    }
}
