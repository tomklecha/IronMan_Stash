package com.tkdev.ironmanstash.infinity_stones.details;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tkdev.ironmanstash.infinity_stones.stones.SingleStone;

import java.util.List;

public class SingleStonePagerAdapter extends FragmentStatePagerAdapter {


    private Cursor cursor;
    private List<SingleStone> singleStoneList;


    public SingleStonePagerAdapter(FragmentManager fm, Cursor cursor) {
        super(fm);
        this.cursor = cursor;
    }

    public SingleStonePagerAdapter(FragmentManager fm, List<SingleStone> singleStoneList) {
        super(fm);
        this.singleStoneList = singleStoneList;
    }

    @Override
    public Fragment getItem(int position) {
        if (cursor.moveToPosition(position)) {

            return SingleStoneDetail.newInstance(
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3),
                    cursor.getString(4)
            );
        }
        return null;
    }

//    @Override
//    public Fragment getItem(int posInList) {
//        while(singleStoneList.isEmpty())
//
//        if (cursor.moveToPosition(posInList)) {
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

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (cursor.moveToPosition(position)) {
            String title = String.valueOf(cursor.getPosition() + 1);
            return title;

        }
        return null;
    }
}
