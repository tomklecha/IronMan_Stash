package com.tkdev.ironmanstash.infinity_stones.details;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SingleStonePagerAdapter extends FragmentStatePagerAdapter {


    private Cursor cursor;

    public SingleStonePagerAdapter(FragmentManager fm, Cursor cursor) {
        super(fm);
        this.cursor = cursor;
    }

    @Override
    public Fragment getItem(int position) {
        if(cursor.moveToPosition(position)){

            return SingleStoneDetail.newInstance(
                    cursor.getString(0)
            );
        }
        return null;
    }

    @Override
    public int getCount() {
        return cursor.getCount();
    }
}
