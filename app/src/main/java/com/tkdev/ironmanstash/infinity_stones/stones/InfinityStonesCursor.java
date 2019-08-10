package com.tkdev.ironmanstash.infinity_stones.stones;

import android.database.Cursor;
import android.database.CursorWrapper;

public class InfinityStonesCursor extends CursorWrapper {

    public InfinityStonesCursor(Cursor cursor) {
        super(cursor);
    }
}
