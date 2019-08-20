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

    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (cursor.moveToPosition(position)) {
            String title = String.valueOf(cursor.getInt(0));
            return title;

        }
        return null;
    }
}
