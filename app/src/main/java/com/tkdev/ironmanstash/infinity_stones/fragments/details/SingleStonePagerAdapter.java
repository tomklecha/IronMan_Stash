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

        return SingleStoneDetail.newInstance(
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
        return String.valueOf(position+1);
    }

//    CURSOR Adapter

//    private Cursor cursor;

//    public SingleStonePagerAdapter(FragmentManager fm, Cursor cursor) {
//        super(fm);
//        this.cursor = cursor;
//    }

//    @Override
//    public Fragment getItem(int position) {
//        if (cursor.moveToPosition(position)) {
//
//            return SingleStoneDetail.newInstance(
//                    cursor.getString(1),
//                    cursor.getInt(2),
//                    cursor.getString(3),
//                    cursor.getString(4)
//            );
//        }
//        return null;
//    }

//
//    @Override
//    public int getCount() {
//        return cursor.getCount();
//    }
//

//    @Override
//    public CharSequence getPageTitle(int position) {
//        if (cursor.moveToPosition(position)) {
//            String title = String.valueOf(cursor.getPosition() + 1);
//            return title;
//
//        }
//        return null;
//    }

}
