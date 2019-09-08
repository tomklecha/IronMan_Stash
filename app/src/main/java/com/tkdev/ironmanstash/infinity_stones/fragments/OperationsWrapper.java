package com.tkdev.ironmanstash.infinity_stones.fragments;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.tkdev.ironmanstash.infinity_stones.database.StonesContract;
import com.tkdev.ironmanstash.infinity_stones.fragments.details.SingleStone;
import com.tkdev.ironmanstash.infinity_stones.fragments.allstones.InfinityStone;


public class OperationsWrapper extends CursorWrapper {


    public OperationsWrapper(Cursor cursor) {
        super(cursor);
    }

    protected InfinityStone getInfinityStoneList() {

        String uuidString = getString(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_ID));
        String name = getString(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_NAME));
        int imageId = getInt(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_IMAGE));
        int isVisible = getInt(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_VISIBILITY));

        InfinityStone stone = new InfinityStone();

        stone.setStoneName(name);
        stone.setImageId(imageId);
        stone.setIsVisible(isVisible);

        return stone;
    }

    protected SingleStone getDetailStoneList() {

        String uuidString = getString(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_ID));
        String name = getString(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_NAME));
        int color = getInt(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_COLOR));
        int quest = getInt(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_QUEST));
        int password = getInt(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_PASSWORD));


//        TODO stone getter setter from database query 282 page

        SingleStone stone = new SingleStone();

        stone.setName(name);
        stone.setColor(color);
        stone.setQuest(quest);
        stone.setPassword(password);

        return stone;
    }

    protected String getInfinityStoneName() {
        String name = getString(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_NAME));

        return name;
    }

    protected String getDetailStoneName() {
        String name = getString(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_NAME));

        return name;
    }


}
