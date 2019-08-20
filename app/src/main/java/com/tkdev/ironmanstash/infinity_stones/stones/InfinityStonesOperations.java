package com.tkdev.ironmanstash.infinity_stones.stones;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tkdev.ironmanstash.infinity_stones.database.StonesDbHelper;

import java.util.ArrayList;
import java.util.List;

public class InfinityStonesOperations {

    private static InfinityStonesOperations operations;
    private List<InfinityStone> infinityStonesList;
    private SQLiteDatabase database;
    private Context context;

    public static InfinityStonesOperations get(Context context) {
        if (operations == null) {
            operations = new InfinityStonesOperations(context);
        }
        return operations;
    }

    private InfinityStonesOperations(Context context) {
        this.context = context;
        this.database = new StonesDbHelper(context).getWritableDatabase();
        this.infinityStonesList = new ArrayList<>();
    }

    private InfinityCursorWrapper queryStones(String tableName) {

      Cursor cursor = database.query(tableName, null, null, null, null, null, null, null);

        return new InfinityCursorWrapper(cursor);
    }

    public List<InfinityStone> getInfinityStoneList(String tableName) {
        List<InfinityStone> list =  new ArrayList<>();

        InfinityCursorWrapper cursorWrapper = queryStones(tableName);


//        TODO all getters for each element to list
        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                list.add(cursorWrapper.getIF());
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }
        return list;

    }
    public List<InfinityStone> getDetailStoneList(String tableName) {
        List<InfinityStone> list =  new ArrayList<>();

        InfinityCursorWrapper cursorWrapper = queryStones(tableName);


//        TODO all getters for each element to list
        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
//                list.add(cursorWrapper.)
            }
        }finally {
            cursorWrapper.close();
        }
        return list;

    }
}
