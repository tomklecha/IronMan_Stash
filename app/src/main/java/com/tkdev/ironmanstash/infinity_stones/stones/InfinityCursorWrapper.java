package com.tkdev.ironmanstash.infinity_stones.stones;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.tkdev.ironmanstash.infinity_stones.database.StonesContract;
import com.tkdev.ironmanstash.infinity_stones.database.StonesDbHelper;

public class InfinityCursorWrapper extends CursorWrapper {

    public InfinityCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public InfinityStone getIF() {

        String uuidString = getString(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_ID));
        String name = getString(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_NAME));
        int imageId = getInt(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_IMAGE));
        int isVisible = getInt(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_VISIBILITY));


//        TODO stone getter setter from database query 282 page

        InfinityStone stone = new InfinityStone();

        stone.setStoneName(name);
        stone.setImageId(imageId);
        stone.setIsVisible(isVisible);

        return stone;
    }

    public String getIFName(){
        String name = getString(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_NAME));

        return name;
    }


}
